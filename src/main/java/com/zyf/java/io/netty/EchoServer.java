package com.zyf.java.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;


/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 9:56
 **/
public class EchoServer {


    public void bind(int port) throws Exception {

        // 创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChildChannelHandler())
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * @see io.netty.handler.codec.DelimiterBasedFrameDecoder 通过分隔符来判断消息的边界
     * @see io.netty.handler.codec.FixedLengthFrameDecoder 通过固定长度来判断消息的边界
     *
     *
     */
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {

            // 按照换行符来分割发送tcp报文
            socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(20));
            // 将发送过来的字符组装成字符串
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new MyHttpServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer().bind(8080);
    }

    public static class MyHttpServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body = (String) msg;
            System.out.println("客户端请求:" + body);

            byte[] bytes = ("server say我是一头猪，天天笑嘻嘻，哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈").getBytes();
            ByteBuf buf = Unpooled.buffer(bytes.length);
            buf.writeBytes(bytes);
            ctx.writeAndFlush(buf);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }
}
