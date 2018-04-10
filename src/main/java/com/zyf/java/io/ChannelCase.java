package com.zyf.java.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 下午2:42
 * 获得一个文件的io渠道，申请一块缓冲区，走货
 */
public class ChannelCase {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("/Users/zyf/Documents/zyf/洪泛，想到这个...就这样来吧a，想到什么说什么，反正也没有逻辑。你真的很好啊，最开心的记忆便是把头", "rw");

            FileChannel channel = file.getChannel(); //拿到文件channel

            ByteBuffer buffer = ByteBuffer.allocate(512); //拿到一块512字节的缓冲区

            int hasRead = -1;
            StringBuilder sb = new StringBuilder();
            do {
                hasRead = channel.read(buffer); //这个和InputStream类似，往buffer里写数据
                buffer.flip();  //将buffer切换成读模式
                if (hasRead > 0) {
                    sb.append(new String(buffer.array(), 0, hasRead));
                }
                buffer.clear(); //清空buffer
            } while (hasRead != -1);

            System.out.println(sb);
        } catch (Exception e) {
            throw e;
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
