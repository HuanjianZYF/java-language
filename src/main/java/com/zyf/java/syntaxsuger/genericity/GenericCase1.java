package com.zyf.java.syntaxsuger.genericity;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 上午9:34
 * 对比可知，用基类实现和用泛型实现的区别是 用泛型时得到的静态类型更加准确
 * 泛型语法糖仅仅是加了强制转型的指令
 */
public class GenericCase1 {

    //用基类实现
    public static int method1(Comparable[] entities, Comparable standard) {
        int count = 0;
        if (entities != null && entities.length > 0) {
            for (Comparable each : entities) {
                if (each.compareTo(standard) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    //用泛型实现
    public static <T extends Comparable<T>> int method2(T[] entities, T standard) {
        int count = 0;
        if (entities != null && entities.length > 0) {
            for (T each : entities) {
                if (each.compareTo(standard) > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
