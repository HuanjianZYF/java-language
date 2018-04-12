package com.zyf.java.annotation;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 下午5:04
 * //使用了一个空虚的注解
 * 配了一个注解解析器，所以spring的注解解析很有可能就是在容器启动的时候进行的
 */
public class Main {

    //现在只能在类加载时解析注解，但在每个类上这样写也不是办法..
    static {
        ZyfPaser.parse(Main.class);
    }

    @Zyf(desc="z", hello="y")
    public static void f() {
        System.out.println("helloWorld!");
    }

    public static void main(String[] args) {
        f();
    }
}
