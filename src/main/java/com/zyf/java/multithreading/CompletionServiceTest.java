package com.zyf.java.multithreading;

import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2018/7/28 下午5:40
 */
//计算1+2+...+99
public class CompletionServiceTest {
	
	private static final ExecutorService executor = Executors.newFixedThreadPool(5);
	private static final CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
	
	public static void main(String[] args) {
		for (int i = 0 ; i < 5; i++) {
			final int a = i;
			Callable<Integer> callable = new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return caculate(a);
				}
			};
			completionService.submit(callable);
		}
		
		int sum = 0;
		try {
			for (int i = 0; i < 5; i++) { //最好设置一个阻塞的时间
				Future<Integer> future = completionService.poll(1, TimeUnit.SECONDS);
				sum += future.get();
			}
		} catch (Throwable e) {
		}
		
		System.out.println(sum);
	}   
	
	private static Integer caculate(int a) {
		int sum = 0;
		for (int i = a * 20; i <= a * 20 + 19; i++) {
			sum += i;
		}
		return sum;
	}
}
