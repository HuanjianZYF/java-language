package com.zyf.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author zyf
 * @CreateAt 2018/4/11 上午9:00
 *
 * 类加载时把类型信息都放在内存了，通过反射可以获得和修改这些信息
 * spring通过反射构造了一个放了很多bean的容器就很好理解了
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = ClassA.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        ClassA instance = (ClassA) constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

class ClassA {
    private String a;
    private Double b;

    public int inc(int c) {
        return 1;
    }

    private ClassA() {

    }
}
