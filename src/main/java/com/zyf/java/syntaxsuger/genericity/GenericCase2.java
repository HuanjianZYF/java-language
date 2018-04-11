package com.zyf.java.syntaxsuger.genericity;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 上午10:08
 * java的泛型是骗人的
 */
public class GenericCase2 {

    public static void main(String[] args) {

        //泛型 ? extends BaseClass 可以从它那里读到元素，但是不能写入
        List<? extends Number> list = Arrays.asList(new Integer(1), new Integer(2));
//        list.add(new Integer(1));
        System.out.println(list.get(1));

        //泛型 ? super ChildClass 读里面的元素时只能以Object类型来读，但是可以写入元素
        List<? super Integer> list1 = Arrays.asList(new Integer(1), new Integer(2));
//        Integer i = list1.get(1);
        list1.add(new Integer(1));
    }
}
