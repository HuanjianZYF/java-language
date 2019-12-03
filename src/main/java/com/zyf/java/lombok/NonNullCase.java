package com.zyf.java.lombok;

import lombok.NonNull;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 14:35
 **/
public class NonNullCase {

    public static void main(String[] args) {
        A a = new A("1");

        a.print("");
    }

    static class A {
        private String name;

        /**
         * 在方法中加上 @NonNull 可以自动进行判空
         * @param name
         */
        public A(@NonNull String name) {
            this.name = name;
        }

        public void print(@NonNull String msg) {
            System.out.println(msg);
        }
    }
}

