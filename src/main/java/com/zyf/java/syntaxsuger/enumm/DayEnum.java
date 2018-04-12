package com.zyf.java.syntaxsuger.enumm;

import java.util.Arrays;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 下午1:56
 * 枚举类其实继承了java.lang.Enum类型，有name和ordinal两个字段
 * 在类中根据定义顺序静态初始化了这些枚举值
 * 可以像一个普通类一样，在里面加字段和方法
 */
public enum DayEnum {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String desc;

    DayEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DayEnum.values()));
        System.out.println(DayEnum.valueOf("MONDAY").ordinal());

        //枚举类配合switch
        DayEnum day = DayEnum.FRIDAY;
        switch (day) {
            case MONDAY: {
                System.out.println("1");
                break;
            }
            case FRIDAY: {
                System.out.println("5");
                break;
            }
        }

        //通过反射获得枚举类所有成员
        Class<?> clazz = day.getClass();
        if (clazz.isEnum()) {
            DayEnum[] members = (DayEnum[]) clazz.getEnumConstants();
            System.out.println(Arrays.toString(members));
        }

    }
}
