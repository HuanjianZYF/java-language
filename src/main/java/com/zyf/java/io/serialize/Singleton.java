package com.zyf.java.io.serialize;

import java.io.Serializable;

/**
 * @Author zyf
 * @CreateAt 2018/4/16 上午10:37
 *
 * 一个即使序列化也能保持单例的单例
 */
public class Singleton implements Serializable {

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Object readResolve() throws Exception {
        return SingletonHolder.instance;
    }
}
