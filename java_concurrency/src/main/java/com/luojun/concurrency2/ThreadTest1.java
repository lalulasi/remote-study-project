package com.luojun.concurrency2;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-02-28 16:18
 **/
public class ThreadTest1 {
    final Object object = new Object();

    public void test(){
        synchronized (object){
            System.out.println("hello world");
        }
    }
}
