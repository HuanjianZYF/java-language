package com.zyf.java.number;

import java.math.BigDecimal;

/**
 * @Author zyf
 * @CreateAt 2018/4/9 上午9:32
 * 精确浮点数计算，经常用来保留小数
 */
public class BigDecimalCase {

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("9999999.9999999999");
        BigDecimal bigDecimal2 = new BigDecimal("7777777.6666666666");
        System.out.println("加" + bigDecimal1.add(bigDecimal2));
        System.out.println("减" + bigDecimal1.subtract(bigDecimal2));
        System.out.println("乘" + bigDecimal1.multiply(bigDecimal2));
        System.out.println("除" + bigDecimal1.divide(bigDecimal2, 3, BigDecimal.ROUND_HALF_UP));

        //这个doubleValue的最后一位变成了7，所以确实double这种还是少用
        System.out.println(bigDecimal2.intValue());
        System.out.println(bigDecimal2.doubleValue());

        //保留小数
        System.out.println(bigDecimal2.setScale(3, BigDecimal.ROUND_HALF_UP));

    }
}
