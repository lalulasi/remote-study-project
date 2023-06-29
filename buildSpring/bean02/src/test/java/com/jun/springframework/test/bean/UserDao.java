package com.jun.springframework.test.bean;

import com.jun.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-19 16:57
 **/
@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        System.out.println("UserDao begin to create bean first with inti method");
        hashMap.put("10001", "luo");
        hashMap.put("10002", "lalulasi2");
        hashMap.put("10003", "lalulasi3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }


    public void initDataMethod(){

    }

    public void destroyDataMethod(){
        System.out.println("UserDao end and destroy bean");
    }
}
