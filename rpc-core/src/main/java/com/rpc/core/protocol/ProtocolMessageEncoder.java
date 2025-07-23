package com.rpc.core.protocol;

import io.vertx.core.buffer.Buffer;

import java.io.IOException;

/**
 * 消息编码器
 */
public class ProtocolMessageEncoder {

    public static Buffer encode(ProtocolMessage<?> protocolMessage) throws IOException {
        if (protocolMessage == null || protocolMessage.getHeader() == null) {

        }
    }
}
