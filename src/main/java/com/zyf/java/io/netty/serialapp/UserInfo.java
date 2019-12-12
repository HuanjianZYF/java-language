package com.zyf.java.io.netty.serialapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author wb-zyf471922
 * @Date 2019/12/12 16:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {

    private String userName;
    private int age;
}
