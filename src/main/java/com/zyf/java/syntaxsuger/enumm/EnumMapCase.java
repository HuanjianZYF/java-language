package com.zyf.java.syntaxsuger.enumm;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyf
 * @CreateAt 2018/4/12 上午9:54
 *
 * enumMap的使用，key为enum的Map
 * 由于枚举的有界性，底层是两个数组，效率会比较高
 */
public class EnumMapCase {

    public static void main(String[] args) {
        List<DayEnum> list = Arrays.asList(DayEnum.values());
        Map<DayEnum, Integer> enumMap = new EnumMap<DayEnum, Integer>(DayEnum.class);
        for (DayEnum each : list) {
            if (enumMap.get(each) == null) {
                enumMap.put(each, 1);
            } else {
                enumMap.put(each, enumMap.get(each) + 1);
            }
        }

        System.out.println(enumMap);
    }
}

