package com.rpc.springboot.starter.bootstrap;

import com.rpc.core.RpcApplication;
import com.rpc.core.config.RegistryConfig;
import com.rpc.core.config.RpcConfig;
import com.rpc.core.model.ServiceMetaInfo;
import com.rpc.core.registry.LocalRegistry;
import com.rpc.core.registry.Registry;
import com.rpc.core.registry.RegistryFactory;
import com.rpc.springboot.starter.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * RPC 服务提供者启动
 */
@Slf4j
public class RpcProviderBootstrap implements BeanPostProcessor {

    /**
     * Bean 初始化后执行，注册服务
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        RpcService rpcService = beanClass.getAnnotation(RpcService.class);
        if (rpcService != null) {
            // 需要注册服务
            // 1.获取服务基本信息
            Class<?> interfaceClass = rpcService.interfaceClass();
            // 默认值处理
            if (interfaceClass == void.class) {
                // 判断是否实现为空
                Class<?>[] interfaces = beanClass.getInterfaces();
                if (interfaces.length == 0) {
                    throw new RuntimeException(beanClass.getName() + " 没有实现任何接口");
                }
                interfaceClass = beanClass.getInterfaces()[0];
            }
            String serviceName = interfaceClass.getName();
            String serviceVersion = rpcService.serviceVersion();
            // 2.注册服务
            // 本地注册
            LocalRegistry.register(serviceName, beanClass);
            // 全局配置
            final RpcConfig rpcConfig = RpcApplication.getRpcConfig();
            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceVersion(serviceVersion);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
