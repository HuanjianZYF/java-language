package com.zyf.java.multithreading;

import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2018/7/29 上午9:22
 */
public class AsycCaculateSimulate {
	
	public static void main(String[] args) {
		new AsycCaculateSimulate().start();
	}
	
	private void start() {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = caculateAsyn(executorService); //算异步计算的
		caculateSyn(); //算同步的
		Integer i = getAsyn(executorService, future); //得到异步计算的结果
		System.out.println(i);
	}
	
	private Future<Integer> caculateAsyn(ExecutorService executorService) {
		try {
			Callable<Integer> callable = new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return doCaculate();
				}
			};
			return executorService.submit(callable);
		} catch (Exception e) {
		} 
		
		return null;
	}
	
	private void caculateSyn() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
	
	private Integer getAsyn(ExecutorService executorService, Future<Integer> future) {
		try {
			return future.get(1, TimeUnit.SECONDS);
		} catch (Throwable e) {
		} finally {
			future.cancel(true); //取消一个已完成的任务并无大碍
			executorService.shutdown();
		}
		
		return null;
	}
	
	private Integer doCaculate() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return 1;
	}
}
