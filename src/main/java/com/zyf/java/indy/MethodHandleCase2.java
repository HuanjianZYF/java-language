package com.zyf.java.indy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author zyf
 * @CreateAt 2018/4/4 下午3:40
 *
 * 这个case崩了，意图是孙子去执行爷爷的方法，在不实例化一个爷爷的条件下
 * 古文诚欺我
 *
 * 大胆猜测，不反射，这根本做不到, 反射也做不到
 * 大概实例方法并不能脱离对象而存在
 */
public class MethodHandleCase2 {

    class GrandFather {
        public void f() {
            System.out.println("a");
        }
    }

    class Father extends GrandFather {
        public void f() {
            System.out.println("b");
        }
    }

    class Son extends Father {
        public void f() {
            try {
                MethodType methodType = MethodType.methodType(void.class);

                //用invokespecial 执行爷爷的f 结果出来的是爸爸的f 其实我认为invokespecial甚至不能执行实例化方法 不管了
                MethodHandle methodHandle =
                    MethodHandles.lookup().findSpecial(GrandFather.class, "f", methodType, Son.class);
                methodHandle.invoke(this);
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] arags) {
        (new MethodHandleCase2().new Son()).f();
    }
}
