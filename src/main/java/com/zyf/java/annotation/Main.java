package com.zyf.java.annotation;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 下午5:04
 * 使用了一个空虚的注解
 */
public class Main {

    @Zyf(desc="z", hello="y")
    public static void f() {
        System.out.println("helloWorld!");
    }

    public static void main(String[] args) {
        f();
    }
}
