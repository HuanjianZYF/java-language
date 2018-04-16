package com.zyf.java.multithreading.threadapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author zyf
 * @CreateAt 2018/4/12 下午1:46
 *
 * 可以让线程执行带返回值，实现Callable即可
 * 然后利用线程池的submit方法，得到Future类型的返回值
 */
public class ThreadCase2 {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future<String>> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(pool.submit(new MyThread2()));
        }

        for (Future<String> str : list) {
            System.out.println(str.get());
        }

        pool.shutdown();
    }

}

class MyThread2 implements Callable<String> {

    @Override public String call() throws Exception {
        return "zzz";
    }
}
