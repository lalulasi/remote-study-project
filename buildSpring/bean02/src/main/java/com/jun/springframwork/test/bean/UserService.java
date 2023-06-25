package com.jun.springframwork.test.bean;

import com.jun.springframwork.beans.factory.DisposableBean;
import com.jun.springframwork.beans.factory.InitializingBean;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:36
 **/
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    //private String name;
    private UserDao userDao;
    private String company;

//    public UserService(String name){
//        this.name = name;
//    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public void showUser(){
        System.out.println("查询用户信息：name: " + userDao.queryUserName(uId) + ", company: " + company);
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet, 在属性设置后执行");
    }
}
