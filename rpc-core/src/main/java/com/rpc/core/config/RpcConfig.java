package com.rpc.core.config;

import com.rpc.core.constant.RpcConstant;
import com.rpc.core.fault.retry.RetryStrategyKeys;
import com.rpc.core.fault.tolerant.TolerantStrategyKeys;
import com.rpc.core.loadbalancer.LoadBalancerKeys;
import com.rpc.core.serializer.SerializerKeys;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * RPC 框架配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RpcConfig implements Serializable {

    /**
     * 名称
     */
    private String name = "Hangz";

    /**
     * 版本号
     */
    private String version = RpcConstant.DEFAULT_SERVICE_VERSION;

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 模拟调用
     */
    private Boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JSON;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.FIXED_INTERVAL;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;

}
