package com.zyf.java.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 下午3:11
 * buffer的实现类似于inputstream  数据结构也是 position，limit，capacity，mark
 * 旗下有各种数据类型的buffer
 */
public class BufferCase {

    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(512);
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        buffer.put("177".getBytes());
        System.out.println(buffer.position());

        RandomAccessFile file = null;
        RandomAccessFile file2 = null;
        try {
            file = new RandomAccessFile("/Users/zyf/Documents/zyf/alter table pay_serial drop constraint FK_serial_p", "rw");
            FileChannel channel1 = file.getChannel(); //拿到文件channel

            file2 = new RandomAccessFile("/Users/zyf/Documents/zyf/随笔", "rw");
            FileChannel channel2 = file.getChannel(); //拿到文件channel

            channel1.transferFrom(channel2, 0, 1000); //直接在通道之间传输
        } catch (Exception e) {
            throw e;
        } finally {
            if (file != null) {
                file.close();
            }
            if (file2 != null) {
                file2.close();
            }
        }
    }
}
