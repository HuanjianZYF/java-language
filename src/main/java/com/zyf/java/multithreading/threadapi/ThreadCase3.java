package com.zyf.java.multithreading.threadapi;

import java.util.concurrent.TimeUnit;

/**
 * @Author zyf
 * @CreateAt 2018/4/12 下午2:02
 *
 */
public class ThreadCase3 {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }

        System.out.println("hello world");
    }
}

class Thread1 implements Runnable {

    @Override public void run() {

        System.out.println("1");
    }
}
