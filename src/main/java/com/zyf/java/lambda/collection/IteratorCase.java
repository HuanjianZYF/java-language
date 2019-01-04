package com.zyf.java.lambda.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/3 10:37
 **/
public class IteratorCase {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 5, 5, 8, 7, 8, 4, 9);

        // 可以用iterator遍历，消费void的
        Iterator<Integer> iterator = list.iterator();
        iterator.forEachRemaining((x -> System.out.println(x + 1)));

        // 认识一下Predicate这个类
        list.removeIf(x -> x == 3);
        System.out.println(list);

        // 试一波stream
        List<Integer> newList = new ArrayList<>();
        newList = list.stream()
            .filter(x -> x > 3)
            .distinct()
            .sorted()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println(newList);

        // 好吧，就是没见过Stream.of()
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8};
        List<Integer> list2 = Stream.of(array)
                                    .collect(Collectors.toList());
        System.out.println(list2);
    }
}
