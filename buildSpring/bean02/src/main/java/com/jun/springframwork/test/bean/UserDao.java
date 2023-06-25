package com.jun.springframwork.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-19 16:57
 **/
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void initDataMethod(){
        System.out.println("UserDao begin to create bean first with inti method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("UserDao end and destroy bean");
    }
}
