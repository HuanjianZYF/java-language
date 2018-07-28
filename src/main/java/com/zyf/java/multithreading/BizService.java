package com.zyf.java.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zyf
 * @date 2018/7/27 上午9:22
 */
public class BizService {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	private static BizService bizService;
	private static final Integer lock = 1;
	
	public void produce(Integer i) {
		try {
			queue.put(i);
			System.out.print("生产" + i);
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void consume() {
		try {
			Integer value = queue.take();
			System.out.println("消费" + value);
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static synchronized BizService getInstance() {
		if (bizService == null) {
			bizService = new BizService();
		}
		
		return bizService;
	}
	
	private BizService() {
	}
}
