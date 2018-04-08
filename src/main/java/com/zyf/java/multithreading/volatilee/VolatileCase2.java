package com.zyf.java.multithreading.volatilee;

/**
 * @Author zyf
 * @CreateAt 2018/4/8 上午10:59
 * 当MyThread的running变量不是volatile时，即使在主线程把running设置为false，MyThread线程中的running依然是true
 * 因为MyThread的工作内存并不会改变，当加了volatile时，则强制在use这个变量时 刷新这个变量的修改
 * 保证了volatile的变量是"可见的"，所以volatile的使用场景一般是把这个变量来当作条件判断...
 */
public class VolatileCase2 {

    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000L);
        thread.setRunning(false);
    }
}

class MyThread extends Thread {

    private volatile boolean running = true;

    @Override public void run() {
        System.out.println("start");
        while (running){};
        System.out.println("end");
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

