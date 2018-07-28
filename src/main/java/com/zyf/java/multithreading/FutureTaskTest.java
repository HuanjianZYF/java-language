package com.zyf.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zyf
 * @date 2018/7/28 上午8:30
 */
public class FutureTaskTest {
	
	public static void main(String[] args) {
		
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
				}
				return 8888;
			}
		});
		new Thread(task).start();
		
		try {
			Integer a = task.get();
			System.out.println(a);
		} catch (Throwable e) {
		}
	}
}
