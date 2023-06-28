package com.jun.springframework.test.bean;

import com.jun.springframework.stereotype.Component;

import java.util.Random;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-28 16:40
 **/
@Component("studentService")
public class StudentService implements IUserService{
    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "lalulasi，100001，shanghai";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
