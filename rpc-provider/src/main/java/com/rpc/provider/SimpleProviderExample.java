package com.rpc.provider;

import com.rpc.common.service.UserService;
import com.rpc.core.RpcApplication;
import com.rpc.core.config.RegistryConfig;
import com.rpc.core.config.RpcConfig;
import com.rpc.core.model.ServiceMetaInfo;
import com.rpc.core.registry.LocalRegistry;
import com.rpc.core.registry.Registry;
import com.rpc.core.registry.RegistryFactory;
import com.rpc.core.server.HttpServer;
import com.rpc.core.server.VertxHttpServer;
import com.rpc.provider.service.UserServiceImpl;


public class SimpleProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);
        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
