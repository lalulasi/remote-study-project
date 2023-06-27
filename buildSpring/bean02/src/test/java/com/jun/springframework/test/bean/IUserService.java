package com.jun.springframework.test.bean;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-27 17:15
 **/
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
