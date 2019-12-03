package com.zyf.java.lombok;

import lombok.var;

import java.util.ArrayList;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 14:27
 **/
public class VarCase {

    /**
     * var 和 val 都是用来推测类型，区别是 var不是final的
     * @param args
     */
    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add("zyf");
        System.out.println(list);
    }
}
