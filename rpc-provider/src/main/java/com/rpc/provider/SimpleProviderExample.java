package com.rpc.provider;

import com.rpc.demo.server.HttpServer;
import com.rpc.demo.server.VertxHttpServer;
import lombok.extern.slf4j.Slf4j;


public class SimpleProviderExample {
    public static void main(String[] args) {
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
