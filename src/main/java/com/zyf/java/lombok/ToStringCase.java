package com.zyf.java.lombok;

import lombok.Setter;
import lombok.ToString;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 15:29
 **/
public class ToStringCase {

    public static void main(String[] args) {
        A a = new A();
        a.setId(99L);
        a.setMsg("zyf");

        System.out.println(a);
    }

    @Setter
    @ToString
    static class A {
        private String msg;
        private Long id;
    }
}
