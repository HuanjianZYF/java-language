package com.zyf.java.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/11 13:44
 **/
public class NIOClientCase {

    public static void main(String[] args) throws Exception {
        new Thread(new NIOClient()).start();
    }

    static class NIOClient implements Runnable {

        private String host;
        private int port;
        private Selector selector;
        private SocketChannel socketChannel;
        private boolean stop;

        public NIOClient() {
            host = "127.0.0.1";
            port = 8080;
            stop = false;
            try {
                selector = Selector.open();
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
            } catch (Exception e) {
            }
        }

        @Override
        public void run() {
            try {
                connect();
            } catch (Exception e) {
            }

            while (!stop) {
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    SelectionKey key = null;
                    while (iterator.hasNext()) {
                        key = iterator.next();
                        iterator.remove();
                        try {
                            handle(key);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        private void handle(SelectionKey key) throws Exception {
            if (key.isValid()) {
                SocketChannel sc = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    System.out.println("可以连接..");
                    if (sc.finishConnect()) {
                        System.out.println("可以连，变成读吧..");
                        sc.register(selector, SelectionKey.OP_READ);
                        doWrite(sc);
                    } else {
                        System.out.println("可以连，但是挂了..");
                        System.exit(1);
                    }
                }

                if (key.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int size = sc.read(buffer);
                    if (size > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String res = new String(bytes, "UTF-8");
                        System.out.println(res);
                        stop = true;
                    }
                }
            }
        }

        private void connect() throws Exception {
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                System.out.println("连上了，等待读..");
                socketChannel.register(selector, SelectionKey.OP_READ);
                //doWrite(socketChannel);
            } else {
                System.out.println("没连上..继续等");
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        }

        private void doWrite(SocketChannel socketChannel) throws Exception {
            System.out.println("我写数据给服务端拉..");
            byte[] bytes = "hello ooo".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();
            socketChannel.write(buffer);
        }
    }
}
