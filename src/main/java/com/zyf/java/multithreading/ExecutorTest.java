package com.zyf.java.multithreading;

import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2018/7/28 下午3:38
 */
public class ExecutorTest {
	private static final Executor executor2 = Executors.newFixedThreadPool(5); //大小为5的线程池
	private static final Executor executor3 = Executors.newCachedThreadPool();
	private static final Executor executor = Executors.newSingleThreadExecutor();
	private static final Executor executor4 = Executors.newScheduledThreadPool(5);
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("执行中..");
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
				}
			}
		};
		for (int i = 0; i < 1000; i++) {
			executor.execute(runnable);
		}
	}
}
