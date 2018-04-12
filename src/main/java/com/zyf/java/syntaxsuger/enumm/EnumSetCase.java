package com.zyf.java.syntaxsuger.enumm;

import java.util.EnumSet;

/**
 * @Author zyf
 * @CreateAt 2018/4/12 上午10:16
 * 底层充满了位运算 没啥兴趣 它很快
 */
public class EnumSetCase {

    public static void main(String[] args) {
        EnumSet<DayEnum> set = EnumSet.noneOf(DayEnum.class);
        System.out.println(set);
        set.add(DayEnum.MONDAY);
        System.out.println(set);

        EnumSet<DayEnum> set2 = EnumSet.allOf(DayEnum.class);
        System.out.println(set2);
        set2.remove(DayEnum.MONDAY);
        System.out.println(set2);

    }
}
