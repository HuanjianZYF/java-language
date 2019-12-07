package com.zyf.java.multithreading.future;

import java.util.concurrent.CompletableFuture;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/6 20:05
 **/
public class CompletableFutureCase2 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future = CompletableFuture.supplyAsync(CompletableFutureCase2::h);

        System.out.println(future.get());
    }

    private static int h() {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
        }

        return 1;
    }
}
