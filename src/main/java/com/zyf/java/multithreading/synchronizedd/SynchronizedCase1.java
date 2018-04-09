package com.zyf.java.multithreading.synchronizedd;

/**
 * @Author zyf
 * @CreateAt 2018/4/8 下午4:44
 * 在inc中锁掉了变量a，结果居然还是小于200000
 * 原因是synchronized实际上锁的是一个引用，也就是某个地址，在Integer自动装拆箱之后，
 * a的地址已经发生变化。这也从侧面说明了，它锁定的是同一个引用地址，不会随着a这个引用的变化而变化。
 * 把synchronized加在inc方法上可以得到正确结果
 */
public class SynchronizedCase1 {

    private static Integer a = 0;

    private static void inc() {
        synchronized (a) {
            a++;
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run () {
                    for (int j = 0; j < 10000; j++) {
                        inc();
                    }
                }
            }
            );
            threads[i].start();
        }

        //主线程等待别的线程停止
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(a);
        System.out.println(System.currentTimeMillis());
    }
}
