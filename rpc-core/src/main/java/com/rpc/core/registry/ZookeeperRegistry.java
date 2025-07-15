package com.rpc.core.registry;

import com.rpc.core.config.RegistryConfig;
import com.rpc.core.model.ServiceMetaInfo;

import java.util.List;

/**
 * Zookeeper 注册中心
 */
public class ZookeeperRegistry implements Registry{

    @Override
    public void init(RegistryConfig registryConfig) {

    }

    @Override
    public void register(ServiceMetaInfo serviceMetaInfo) throws Exception {

    }

    @Override
    public void unRegister(ServiceMetaInfo serviceMetaInfo) {

    }

    @Override
    public List<ServiceMetaInfo> serviceDiscovery(String serviceKey) {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void heartBeat() {

    }
}
