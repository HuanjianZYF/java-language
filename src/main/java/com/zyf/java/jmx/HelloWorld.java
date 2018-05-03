package com.zyf.java.jmx;

/**
 * @Author zyf
 * @CreateAt 2018/5/3 下午5:45
 */
public class HelloWorld implements HelloWorldMBean {
    @Override public void f() {
        System.out.println("f");
    }

    @Override public void g() {
        System.out.println("g");
    }
}
