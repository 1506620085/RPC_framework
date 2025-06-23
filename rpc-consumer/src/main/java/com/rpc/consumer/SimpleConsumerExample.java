package com.rpc.consumer;

import com.rpc.common.model.User;
import com.rpc.common.service.UserService;
import com.rpc.demo.proxy.ServiceProxyFactory;


/**
 * 简易服务消费者示例
 */
public class SimpleConsumerExample {
    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("Hangz");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
