package com.zyf.java.multithreading.holder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyf
 * @date 2018/7/25 下午2:26
 */
public class ThreadLocalHolder {
	
	private ThreadLocal<Map<String, Object>> threadLocal;
	
	{
		threadLocal = new ThreadLocal<>();
		Map<String, Object> map = new HashMap<>();
		threadLocal.set(map);
	}
	
	public void setValue(String s, Object o) {
		threadLocal.get().put(s, o);
	}
	
	public Object getValue(String s) {
		return threadLocal.get().get(s);
	}

}
