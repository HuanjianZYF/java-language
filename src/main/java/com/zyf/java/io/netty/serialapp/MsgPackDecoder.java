package com.zyf.java.io.netty.serialapp;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 16:14
 **/
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list)
        throws Exception {
        //从msg中获取需要解码的byte数组
        final int length = byteBuf.readableBytes();
        byte[] b = new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(), b,0,length);
        //使用MessagePack的read方法将其反序列化成Object对象，并加入到解码列表out中
        MessagePack msgpack = new MessagePack();
        list.add(msgpack.read(b));
    }
}
