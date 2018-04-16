package com.zyf.java.multithreading.threadapi;

import com.zyf.java.annotation.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Author zyf
 * @CreateAt 2018/4/12 上午11:31
 *
 * 线程池:newCachedThreadPool的线程数是Integer.MAXVALUE
 *       newFixedThreadPool则是指定了线程池的大小
 */
public class ThreadCase1 {

    public static void main(String[] args) {

//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new MyThread());
//            thread.start();
//        }

//        //创建一个线程池来管理线程，默认线程池基本可以容纳所有线程
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new MyThread());
//        }
//
//        exec.shutdown();

        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            exec.execute(new MyThread());
        }

        exec.shutdown();
    }
}

class MyThread implements Runnable {

    private int id ;
    private static int n = 0;

    public MyThread() {
        id = n;
        n++;
    }

    public void status() {
        System.out.println(" hh" + id);
    }

    @Override public void run() {
        while(true) {
            status();
            Thread.yield();
        }
    }
}
