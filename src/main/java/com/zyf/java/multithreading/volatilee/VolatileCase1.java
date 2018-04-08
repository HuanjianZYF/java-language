package com.zyf.java.multithreading.volatilee;

/**
 * @Author zyf
 * @CreateAt 2018/4/8 上午10:21
 * volatile的变量可以保证 在这个变量被use之前，已经刷新了别的线程对它的修改，因此保证了可见性
 * 但是由于java的运算自身并非原子操作（在变量传递给jvm执行引擎之后运算非原子），所以在并发运算时候还是不能保证操作原子性
 * 少用
 */
public class VolatileCase1 {

    private static volatile int a = 0;

    private static void inc() {
                a++;
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
