package com.zyf.java.multithreading.future;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/6 8:06
 **/
public class FutureCase {

    private static ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 1
        , TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        Future<Integer> future = threadPool.submit(FutureCase::sum);

        int result = 0;
        try {
            result = future.get(10, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            System.out.println("计算和的任务执行出错....");
        } catch (InterruptedException e) {
            System.out.println("计算和的任务被中断了....");
        } catch (TimeoutException e) {
            System.out.println("计算和的任务超时了.....");
        }

        System.out.println(result);
    }

    private static int sum() {
        return IntStream.rangeClosed(1, 1000).sum();
    }
}
