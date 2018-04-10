package com.zyf.java.exception;

/**
 * @Author zyf
 * @CreateAt 2018/4/10 上午9:24
 * 一般一个异常类这样写就可以了,去掉main
 * RuntimeException可以直接在方法里抛出而不用声明throws，普通的Exception需要声明throws，error则不能抛出
 * 所以自定义异常的时候还是应该继承Exception
 */
public class CarException extends RuntimeException {

    public CarException() {

    }

    public CarException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        throw new CarException("a");
    }
}
