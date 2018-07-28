package com.zyf.java.multithreading;

/**
 * @author zyf
 * @date 2018/7/27 上午9:20
 */
public class BlockingQueueTest {
	
	public static void main(String[] args) {
		new ProduceThread().start();
		new ConsumeThread().start();
	}
	
	static class ProduceThread extends Thread {
		BizService bizService = BizService.getInstance();

		@Override
		public void run() {

			for (int i = 0; i < 1000; i++) {
				bizService.produce(i);
			}
		}
	}

	static class ConsumeThread extends Thread {
		BizService bizService = BizService.getInstance();

		@Override
		public void run() {

			for (int i = 0; i < 1000; i++) {
				bizService.consume();
			}
		}
	}
}
