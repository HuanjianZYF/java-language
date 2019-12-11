package com.zyf.java.io.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/10 18:40
 **/
public class TimeClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();

        System.out.println(line);
    }
}
