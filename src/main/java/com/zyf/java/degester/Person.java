package com.zyf.java.degester;

/**
 * @Author zyf
 * @CreateAt 2018/5/2 下午7:24
 */
public class Person {
    private String name;
    private Toy toy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public void say() {
        System.out.println("haha");
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", toy=" + toy + '}';
    }
}
