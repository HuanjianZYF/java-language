package com.zyf.java.number;

import java.math.BigInteger;

/**
 * @Author zyf
 * @CreateAt 2018/4/9 上午10:33
 * 是很普通的大整数运算，它只能是整数，然后能进行所有的整数的运算
 */
public class BigIntegerCase {

    public static void main(String[] args) {

        //用BigInteger做平凡的加减乘除
        BigInteger bigInteger1 = new BigInteger("9999999999999999999999999999999999999999");
        BigInteger bigInteger2 = new BigInteger("8888888888888888888888888888888888888888");
        System.out.println("加" + bigInteger1.add(bigInteger2));
        System.out.println("减" + bigInteger1.subtract(bigInteger2));
        System.out.println("乘" + bigInteger1.multiply(bigInteger2));
        System.out.println("除" + bigInteger1.divide(bigInteger2));
        BigInteger[] a = bigInteger1.divideAndRemainder(bigInteger2);
        System.out.println("商:" + a[0] + ";余:" + a[1]);
        System.out.println("余:" + bigInteger1.mod(bigInteger2));

        //显然int和long根本放不下,结果是溢出后的结果
        System.out.println(bigInteger2.intValue());
        System.out.println(bigInteger2.longValue());

    }
}
