package com.zyf.java.syntaxsuger;

/**
 * @Author zyf
 * @CreateAt 2018/4/7 下午4:32
 * 自动装拆箱，结果看上去很玄学...
 * 觉得e和f是在堆里，c和d在常量池里...
 * ==两边没有运算时不会自动拆箱
 * .equals可以进行拆箱但不能再强转类型
 */
public class AutoBoxCase {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(3L));
    }
}
