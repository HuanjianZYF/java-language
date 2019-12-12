package com.zyf.java.io.messagepack;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 15:56
 **/
public class MessagePackCase {

    public static void main(String[] args) throws Exception {

        // 一个要序列化的对象
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        MessagePack messagePack = new MessagePack();
        // 把对象写成字节
        byte[] bytes = messagePack.write(list);

        // 再把字节转回到对象
        List<String> tranList = messagePack.read(bytes, Templates.tList(Templates.TString));
        System.out.println(tranList);
    }
}
