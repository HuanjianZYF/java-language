package com.zyf.java.io.serialize;

import java.io.*;

/**
 * @Author zyf
 * @CreateAt 2018/4/16 上午10:05
 * 一个简单的可序列化对象
 * 写上writeObject方法和readObject方法可以改写默认的序列化机制
 */
public class Person implements Serializable {

    private Long id;
    private String name;
    private transient Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(age);
    }

    private void readObject(ObjectInputStream inputStream) throws Exception {
        inputStream.defaultReadObject();
        age = inputStream.readInt();
    }

}
