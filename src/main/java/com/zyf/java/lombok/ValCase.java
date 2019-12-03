package com.zyf.java.lombok;

import lombok.val;

import java.util.ArrayList;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 14:22
 **/
public class ValCase {

    /**
     * val 类型的变量可以用来推测类型
     * @param args
     */
    public static void main(String[] args) {

        // 相当于 final ArrayList<String> list = new ArrayList<>();
        val list = new ArrayList<>();
        list.add("zyf");
        System.out.println(list);
    }
}
