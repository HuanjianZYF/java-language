package com.zyf.java.io.netty.serialapp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 16:12
 **/
public class MsgPackEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        MessagePack msgpack = new MessagePack();
        //使用MessagePack对要发送的数据进行序列化
        byte[] raw = msgpack.write(o);
        byteBuf.writeBytes(raw);
    }
}
