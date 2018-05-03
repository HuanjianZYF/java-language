package com.zyf.java.multithreading;

/**
 * @Author zyf
 * @CreateAt 2018/5/3 下午2:17
 *
 * 虚拟机在关闭之前会执行一次关闭钩子
 */
public class ShutdownHookCase {

    public static void main(String[] args) {
        ShutdownHook hook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(hook);
    }

    static class ShutdownHook extends Thread {

        @Override public void run() {
            System.out.println("虚拟机关闭之前要先执行我");
        }
    }
}


