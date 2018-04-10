package com.zyf.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 上午11:02
 * 好吧 普通io流是一个装饰模式的典型 通过FilterInputStream来把 代理类 传进来，之后再装饰
 * FileReader读文件，BufferedReader加缓冲...一般这样用就好了
 */
public class FIleInputStreamCase {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/zyf/Documents/zyf/alter table pay_serial drop constraint FK_serial_p"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                }
            } while(line != null);
            System.out.println(sb);
        } catch (Exception e) {
            throw e;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
