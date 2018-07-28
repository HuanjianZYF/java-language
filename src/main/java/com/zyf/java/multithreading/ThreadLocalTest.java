package com.zyf.java.multithreading;

import com.zyf.java.multithreading.holder.ThreadLocalHolder;

import java.util.Map;

/**
 * @author zyf
 * @date 2018/7/25 上午9:03
 */
public class ThreadLocalTest {
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 20; i++) {
			new NormalThread("" + i).start();
		}
		Thread.sleep(100000000);
	}
	
	static class NormalThread extends Thread {
		
		private String localValue;
		
		@Override
		public void run() {
			ThreadLocalHolder holder = new ThreadLocalHolder();
			holder.setValue("a", localValue);
			holder.setValue("b", 10);
			System.out.println("in thread " + localValue + " value is " + holder.getValue("a") + holder.getValue("b"));
			try {
				Thread.sleep(1000); 
			} catch (Exception e) {
			}
		}
		
		public NormalThread(String s) {
			this.localValue = s;
		}
	}
}
