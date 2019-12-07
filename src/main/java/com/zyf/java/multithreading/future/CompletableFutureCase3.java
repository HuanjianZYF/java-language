package com.zyf.java.multithreading.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/7 8:42
 **/
public class CompletableFutureCase3 {

    public static void main(String[] args) throws Exception {

        long t1 = System.currentTimeMillis();
        // 获取futureList
        List<CompletableFuture<Long>> futureList = IntStream.rangeClosed(1, 5)
            .boxed()
            .map((h) -> CompletableFuture.supplyAsync(CompletableFutureCase3::a))
            .collect(Collectors.toList());

        Long result = futureList.stream()
            .map((a) -> {
                try {
                    return a.get();
                } catch (Exception e) {
                }
                return 0L;
            }).reduce(0L, Long::sum);

        System.out.println(result);
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + "ms");
    }

    private static Long a() {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
        }

        return 1L;
    }
}
