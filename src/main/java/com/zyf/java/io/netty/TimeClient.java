package com.zyf.java.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/11 17:31
 **/
public class TimeClient {

    public static void main(String[] args) {
        new TimeClient().connect(8080, "127.0.0.1");
    }

    private void connect(int port, String address) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 按照换行符来分割发送tcp报文
                        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        // 将发送过来的字符组装成字符串
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new TimeClientHandler());
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
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            byte[] bytes = ("hello服务器，你就是一头猪，呵呵呵呵呵呵加加加啊那我得" + System.getProperty("line.separator")).getBytes();

            for (int i = 0; i < 100; i++) {
                ByteBuf buf = Unpooled.buffer(bytes.length);
                buf.writeBytes(bytes);
                ctx.writeAndFlush(buf);
            }
        }
    }
}
