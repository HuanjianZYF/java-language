package com.zyf.java.collection;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 上午10:14
 * 这个就是 容器和流中出现频率最高的方法了..原来这么好用
 */
public class ArrayCopyCase {

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,4,5};
        int[] b = {9,9,8,8,7,7};

        System.arraycopy(a, 3, b, 0, 5);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
