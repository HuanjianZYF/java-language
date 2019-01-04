package com.zyf.java.lambda.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 10:40
 **/
public class BIConsumerCase {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.forEach(a -> System.out.println(a));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.forEach((x, y) -> System.out.println(x +y));
    }
}
