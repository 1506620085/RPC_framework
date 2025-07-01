package com.rpc.provider;

import com.rpc.common.service.UserService;
import com.rpc.core.RpcApplication;
import com.rpc.core.registry.LocalRegistry;
import com.rpc.core.server.HttpServer;
import com.rpc.core.server.VertxHttpServer;
import com.rpc.provider.service.UserServiceImpl;


public class SimpleProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
