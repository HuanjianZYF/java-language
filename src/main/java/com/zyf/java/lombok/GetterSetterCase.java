package com.zyf.java.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 15:03
 **/
public class GetterSetterCase {

    public static void main(String[] args) {
        A a = new A();
        a.setName("zyf");
        System.out.println(a.getName());
    }

    @Setter
    @Getter
    static class A {
        private String name;

        @Getter(AccessLevel.NONE)
        private String h;
    }
}

