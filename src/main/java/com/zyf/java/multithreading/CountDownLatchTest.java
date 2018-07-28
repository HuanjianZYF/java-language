package com.zyf.java.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @author zyf
 * @date 2018/7/28 上午8:17
 */
public class CountDownLatchTest {
	
	public static void main(String[] args) throws Exception {
		final CountDownLatch latch = new CountDownLatch(10);
		final CountDownLatch startLatch = new CountDownLatch(1);
		
		for (int i = 0; i < 10; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						startLatch.await();
					} catch (Exception e) {
					}
					
					System.out.println("线程执行");
					latch.countDown();
				}
			}.start();
		}
		
		startLatch.countDown();
		latch.await();
		System.out.println("主线程");
	}
}
