package com.zyf.java.lambda.base;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/3 9:52
 **/
public class LambdaBaseCase {

    public static void main(String[] args) {

        // 单方法的接口可以直接用lambda表示，估计lambda的实现和“单方法接口”是吻合的
        Runnable thread = () -> {System.out.println("hello lambda");};
        thread.run();

        // 认识一下Consumer这个类，这个就是一个“单方法接口”
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("cc");

        // Comparator里面有两个抽象方法，居然也是函数接口，咋回事
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(1, 2));

        // 所以函数式接口定义了之后，最主要的作用就是，定义好了之后（twice），可以用lambda表达式的形式，得到这个接口的抽象实现类
        MyFunction myFunction = x -> x + 1;
        System.out.println(myFunction.doFun(100));
    }
}
