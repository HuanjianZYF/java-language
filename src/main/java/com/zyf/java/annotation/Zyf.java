package com.zyf.java.annotation;

import java.lang.annotation.*;

/**
 * 定义了一个我的注解
 * @Document和javadoc有关  @Target指定注解标注的对象 @Retention表明注解一直出现直到运行期
 * 另外注解就像一个接口一样，声明很多没有参数的方法，这些方法名可以在注解使用时当参数
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Zyf {
    String hello() default "zz";
    String desc() default "";
}
