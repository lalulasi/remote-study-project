package com.jun.springframwork.test.bean;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:36
 **/
public class UserService {
    private String uId;

    //private String name;

    private UserDao userDao;


//    public UserService(String name){
//        this.name = name;
//    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }


}
