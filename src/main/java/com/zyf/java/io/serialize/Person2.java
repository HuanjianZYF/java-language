package com.zyf.java.io.serialize;

import java.io.*;

/**
 * @Author zyf
 * @CreateAt 2018/4/16 上午10:05
 * 一个实现Externalizable的序列化对象 它怎么序列化需要自己实现
 */
public class Person2 implements Externalizable {

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

    @Override public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
}
