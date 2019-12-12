package com.zyf.java.io.netty.serialapp;

import com.zyf.java.io.netty.TimeClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 16:26
 **/
public class EncoderClient {

    public static void main(String[] args) {
        new EncoderClient().connect(8080, "127.0.0.1");
    }

    private void connect(int port, String address) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("frameDecoder",
                            new LengthFieldBasedFrameDecoder(63355, 0, 2, 0, 2));
                        socketChannel.pipeline().addLast("msgpack decoder", new MsgPackDecoder());
                        socketChannel.pipeline().addLast("frameEncode", new LengthFieldPrepender(2));
                        socketChannel.pipeline().addLast("msgpack encoder", new MsgPackEncoder());

                        // 按照换行符来分割发送tcp报文
                        //socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        // 将发送过来的字符组装成字符串
                        //socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new TimeClient.TimeClientHandler());
                    }
                });

            ChannelFuture future = bootstrap.connect(address, port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
        } finally {
            group.shutdownGracefully();
        }
    }

    public static class TimeClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body = (String) msg;
            System.out.println("服务端返回" + body);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            UserInfo info = new UserInfo("zyf", 25);
            System.out.println("写了一个对象1" + info);
            ctx.writeAndFlush(info);
            System.out.println("写了一个对象" + info);
        }
    }
}
