package com.zyf.java.degester;

/**
 * @Author zyf
 * @CreateAt 2018/5/2 下午7:24
 */
public class Toy {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Toy{" + "name='" + name + '\'' + '}';
    }
}
