package com.zyf.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 下午4:21
 * 用nio复制文件内容，基于块的io，一直在搬运..
 */
public class CopyFileWithNio {

    public static void main(String[] args) throws Exception {

        RandomAccessFile file1 = null;
        RandomAccessFile file2 = null;
        try {
            file1 = new RandomAccessFile("/Users/zyf/Documents/zyf/随笔", "rw");
            file2 = new RandomAccessFile("/Users/zyf/Documents/zyf/a.txt", "rw");
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
