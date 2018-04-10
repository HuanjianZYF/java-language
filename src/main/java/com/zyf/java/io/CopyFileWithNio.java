package com.zyf.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 下午4:21
 */
public class CopyFileWithNio {

    public static void main(String[] args) throws Exception {

        FileOutputStream file1 = null;
        FileInputStream file2 = null;
        try {
            file1 = new FileOutputStream("/Users/zyf/Documents/zyf/随笔");
            file2 = new FileInputStream("/Users/zyf/Documents/zyf/a.txt");
            FileChannel channel1 = file1.getChannel();
            FileChannel channel2 = file2.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(true) {
                int hasRead = channel1.read(buffer);
                if (hasRead == -1) {
                    break;
                }
                buffer.flip();
                channel2.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (file1 != null) {
                file1.close();
            }
            if (file2 != null) {
                file2.close();
            }
        }
    }
}
