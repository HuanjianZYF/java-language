package com.zyf.java.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/15 8:58
 **/
public class HttpServer {

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
            //socketChannel.pipeline().addLast(new HttpResponseDecoder());
            //socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
            //// 将发送过来的字符组装成字符串
            //socketChannel.pipeline().addLast(new HttpResponseEncoder());

            socketChannel.pipeline().addLast(new HttpServerCodec());
            socketChannel.pipeline().addLast(new MyHttpServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpServer().bind(8080);
    }

    public static class MyHttpServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            if (msg instanceof HttpRequest) {

                // 请求，解码器将请求转换成HttpRequest对象
                HttpRequest request = (HttpRequest) msg;

                // 获取请求参数
                QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.uri());
                String name = "netty";
                if(queryStringDecoder.parameters().get("name") != null) {
                    name = queryStringDecoder.parameters().get("name").get(0);
                }

                // 响应HTML
                String responseHtml = "<html><body>Hello, " + name + "</body></html>";
                byte[] responseBytes = responseHtml.getBytes("UTF-8");
                int contentLength = responseBytes.length;

                // 构造FullHttpResponse对象，FullHttpResponse包含message body
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(responseBytes));
                response.headers().set("Content-Type", "text/html; charset=utf-8");
                response.headers().set("Content-Length", Integer.toString(contentLength));

                ctx.writeAndFlush(response);
            }
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
