package com.zyf.java.indy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author zyf
 * @CreateAt 2018/4/4 下午3:05
 * jvm的invokeDynamic指令 和 java.lang.invoke包，实现了动态语言的特性
 * 所以MethodHandle这个东西可以对应到一个具体的方法，它让你有了虚拟机的视角并去找到某一个方法
 */
public class MethodHandleCase {

    //随便弄一个类它有一个方法
    static class ClassA {
        public void f(String s) {
            System.out.println("a" + s);
        }
    }

    public static void main(String[] args) throws Exception {

        //先要有对象
        ClassA a = new ClassA();

        //这个相当于动态语言的一个方法，它的绑定只与返回值和方法参数有关，不管调用者的静态类型
        MethodType methodType = MethodType.methodType(void.class, String.class);

        //这个其实就是invokevirtual的执行过程，最后绑定到a
        MethodHandle methodHandle = MethodHandles.lookup()
            .findVirtual(ClassA.class, "f", methodType).bindTo(a);

        //竟然能抛出error
        try {
            methodHandle.invoke("sb");
        } catch (Throwable e) {
        }
    }
}
