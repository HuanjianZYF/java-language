package com.zyf.java.multithreading.forkjoin;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/3 13:40
 **/
@AllArgsConstructor
public class SumRecursiveTask extends RecursiveTask<Long> {

    private long[] elements;

    private int start;

    private int end;

    public SumRecursiveTask(long[] elements) {
        this(elements, 0, elements.length);
    }

    @Override
    protected Long compute() {
        int len = end - start + 1;
        if (len <= 5) {
            return sum();
        }

        SumRecursiveTask left = new SumRecursiveTask(elements, start, start + len / 2);
        left.fork();

        SumRecursiveTask right = new SumRecursiveTask(elements, start + len / 2, end);
        Long rightResult = right.compute();
        Long leftResult = left.join();

        return rightResult + leftResult;
    }

    private long sum() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += elements[i];
        }

        return sum;
    }

}
