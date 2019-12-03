package com.zyf.java.lombok;

import lombok.Cleanup;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Author wb-zyf471922
 * @Date 2019/5/14 14:52
 **/
public class CleanUpCase {

    /**
     * CleanUp 可以为某一个资源自动调用close方法，可以在注解里面写字符串，来指定调用某一个方法。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        @Cleanup(value = "close")
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\TanShenghu\\Desktop\\files\\脚本\\大病用药维护.sql"));

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}
