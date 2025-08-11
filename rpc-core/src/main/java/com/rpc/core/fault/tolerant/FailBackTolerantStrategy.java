package com.rpc.core.fault.tolerant;

import com.rpc.core.model.RpcResponse;

import java.util.Map;

/**
 * 降级到其他服务 - 容错策略
 */
public class FailBackTolerantStrategy implements TolerantStrategy{

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // TODO 后续扩展，获取降级的服务并且调用
        return null;
    }
}
