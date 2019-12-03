package com.zyf.java.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/3 13:37
 **/
public class ForkJoinCase {

    public static void main(String[] args) {
        SumRecursiveTask task = new SumRecursiveTask(LongStream.rangeClosed(1, 1000).toArray());
        Long value = new ForkJoinPool().invoke(task);

        System.out.println(value);
    }
}
