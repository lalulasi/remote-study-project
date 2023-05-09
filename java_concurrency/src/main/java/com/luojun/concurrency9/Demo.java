package com.luojun.concurrency9;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-04-18 16:06
 **/
public class Demo {
    private int num = 1;

    public int add(){
        num = num + 2;
        return num;
    }
}
