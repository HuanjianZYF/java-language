package com.zyf.java.io.nio;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/10 19:08
 **/
public class TimeServerWithThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("server start in 8080...");

        while (true) {
            Socket socket = server.accept();
            executorService.submit(() -> consume(socket));
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
