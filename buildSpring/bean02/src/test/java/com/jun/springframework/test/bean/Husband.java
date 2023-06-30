package com.jun.springframework.test.bean;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 15:36
 **/
public class Husband {
    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }
}
