package com.zyf.java.multithreading;

import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2018/7/28 上午8:55
 */
public class BarrierTest {
	
	private static final ExecutorService executor = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) {
		Future<?>[] futures = new Future[5];
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("出栅栏了");
			}
		});
		
		for (int i = 0; i < 5; i++) {
			futures[i] = executor.submit(new SubThread(20 * i, 20 * i + 19, barrier));
		}
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			try {
				sum += (Integer) futures[i].get();
			} catch (Throwable e) {
			}
		}
		System.out.println(sum);
	}
	
	static class SubThread implements Callable<Integer> {
		private int start;
		private int end;
		private CyclicBarrier barrier;

		public Integer call() {
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += i;
			}
			try {
				System.out.println("线程start=" + start + "计算完成,sum=" + sum);
				barrier.await();
			} catch (Exception e) {
			}
			
			return sum;
		}
		
		public SubThread(int start, int end, CyclicBarrier barrier) {
			this.start = start;
			this.end = end;
			this.barrier = barrier;
		}
	}
	
}
