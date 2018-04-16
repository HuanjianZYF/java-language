package com.zyf.java.io.serialize;

import java.io.*;

/**
 * @Author zyf
 * @CreateAt 2018/4/16 上午9:53
 * 一个普通的 把对象写进磁盘再读出
 */
public class SerializeCase1 {

    public static void main(String[] args) throws Exception {
        File file = new File(System.getProperty("user.dir") + File.separator + "person.out");

        Person p = new Person();
        p.setId(1L);
        p.setAge(22);
        p.setName("z");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(p);
        out.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) input.readObject();
        System.out.println(person);
    }
}
