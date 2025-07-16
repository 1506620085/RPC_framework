package com.rpc.consumer;

import com.rpc.core.config.RegistryConfig;
import com.rpc.core.config.RpcConfig;
import com.rpc.core.registry.EtcdRegistry;
import com.rpc.core.registry.Registry;
import com.rpc.core.utils.ConfigUtils;

/**
 * 建议服务消费者示例
 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = new EtcdRegistry();
        registry.
        System.out.println(rpcConfig);
    }
}
