package com.zyf.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author zyf
 * @CreateAt 2018/4/12 上午10:29
 * 注解Zyf的解析器，在适当的时刻，譬如最好像spring容器加载的时候执行
 */
public class ZyfPaser {

    public static void parse(Class<?> clazz) {
        if (clazz == null) {
            return;
        }

        Method[] methods = clazz.getDeclaredMethods();
        if (methods == null || methods.length == 0) {
            return;
        }

        for (Method method : methods) {
            Zyf annotation = method.getAnnotation(Zyf.class);
            if (annotation == null) {
                continue;
            }

            String hello = annotation.hello();
            String desc = annotation.desc();

            System.out.println("zyf 像你问好:" + hello);
            System.out.println("ooo" + desc);
        }
    }
}
