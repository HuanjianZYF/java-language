package com.zyf.java.io.serialize;

import java.io.*;

/**
 * @Author zyf
 * @CreateAt 2018/4/16 上午10:42
 *
 * 确认一下序列化前后依然保持单例
 */
public class SerializeCase2 {

    public static void main(String[] args) throws Exception {
        File file = new File(System.getProperty("user.dir") + File.separator + "single.out");

        Singleton p = Singleton.getInstance();
        p.setId(1L);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(p);
        out.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Singleton singleton = (Singleton) input.readObject();
        System.out.println(singleton == p);
    }
}
