package com.zyf.java.lambda.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 10:58
 **/
public class FunctionCase {

    public static void main(String[] arhs) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(3);

        // .map可以用Function
        List<Integer> newList = list.stream()
            .map(Math::abs)
            .collect(Collectors.toList());
        System.out.println(newList);

    }
}
