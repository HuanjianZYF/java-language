package com.zyf.java.multithreading.future;

import java.util.concurrent.CompletableFuture;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/6 19:05
 **/
public class CompletableFutureCase {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Long> future = new CompletableFuture<>();

        new Thread(() -> {
            future.complete(sum());
        }).start();

        System.out.println(future.get());
    }

    private static Long sum() {
        try {
            Thread.sleep(5000L);
        } catch (Exception e) {
        }

        //return 100L;
        throw new RuntimeException("haha");
    }
}
