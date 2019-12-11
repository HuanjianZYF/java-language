package com.zyf.java.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/11 9:52
 **/
public class NIOServerCase {

    public static void main(String[] args) throws Exception {
        NIOServer server = new NIOServer();
        new Thread(server).start();
    }

    static class NIOServer implements Runnable {

        private Selector selector;

        private ServerSocketChannel serverSocketChannel;

        public NIOServer() {
            try {
                selector = Selector.open();
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(new InetSocketAddress(8080), 1024);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                System.out.println("server start..");
            } catch (Exception e) {
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    SelectionKey selectionKey = null;
                    while (iterator.hasNext()) {
                        selectionKey = iterator.next();
                        iterator.remove();
                        handle(selectionKey);
                    }
                } catch (Exception e) {
                }
            }
        }

        private void handle(SelectionKey selectionKey) throws Exception {
            if (selectionKey.isValid()) {
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                }

                if (selectionKey.isReadable()) {
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int size = sc.read(buffer);
                    if (size > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String body = new String(bytes, "UTF-8");
                        System.out.println("客户端输入：" + body);

                        doWrite(sc);
                    }
                }
                System.out.println("客户端能读？：" + selectionKey.isReadable() + "\n客户端能写？："
                    + selectionKey.isWritable());
            }
        }

        private void doWrite(SocketChannel sc) throws Exception {
            byte[] bytes = "hahha".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();
            sc.write(buffer);
        }
    }
}
