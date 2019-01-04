package com.zyf.java.lambda.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 10:50
 **/
public class ShuangmaohaoCase {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(1.2);
        list.add(-4.3);
        list.forEach(Math::abs);
        System.out.println(list);
    }
}
