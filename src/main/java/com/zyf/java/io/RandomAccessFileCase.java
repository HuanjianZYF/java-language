package com.zyf.java.io;

import java.io.RandomAccessFile;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 下午2:09
 * 顾名思义，它就是可以随机读写的文件类
 * 通过 getFilePointer来得到当前文件指针，seek来移动它
 * 在seek到中间的情况下write会覆盖原来的内容，"我是"这两个字符竟然是占用了6个字节
 * 编码是黑洞
 */
public class RandomAccessFileCase {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("/Users/zyf/Documents/zyf/alter table pay_serial drop constraint FK_serial_p", "rw");
            System.out.println("当前的文件指针" + file.getFilePointer());

            file.seek(20);
            byte[] buffer = new byte[100];
            int hasRead = 0;
            while ((hasRead = file.read(buffer)) > 0) {
                System.out.println(new java.lang.String(buffer, 0, hasRead));
            }

            file.seek(file.length()); //只在在结尾加上话
            file.write("我要在文件末尾加上一些话".getBytes());

            file.seek(3);
            file.write("我是".getBytes());

            for (byte bytee : "我是".getBytes()) {
                System.out.println(bytee);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
