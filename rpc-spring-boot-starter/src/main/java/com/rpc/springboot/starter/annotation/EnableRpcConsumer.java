package com.rpc.springboot.starter.annotation;

/**
 * 启用消费者 RPC 注解
 */
public @interface EnableRpcConsumer {

    /**
     * 需要启动消费者 server
     *
     * @return
     */
    boolean needServer() default true;
}
