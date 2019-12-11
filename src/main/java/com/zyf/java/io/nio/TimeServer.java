package com.zyf.java.io.nio;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/10 18:21
 **/
public class TimeServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("server start in 8080...");

        while (true) {
            Socket socket = server.accept();
            new Thread(() -> consume(socket)).start();
        }
    }

    private static void consume(Socket socket) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("hehe..");
            writer.flush();
        } catch (Exception e) {
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
