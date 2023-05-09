package com.luojun.concurrency;

import com.luojun.concurrency4.CallableTest;

import java.util.concurrent.*;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-20 19:14
 **/
public class YieldThreadTest implements Runnable{
    private String name;

    public YieldThreadTest(String name){
        this.name = name;
    }


    @Override
    public void run() {
        for(int i=0; i<10; i++){
            if("t1".equals(name) && i == 5){
                System.out.println(name + " : " + "pause");
                Thread.yield();
            }
            System.out.println(name + " execute : " + (i + 1));
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t1 = new Thread(new YieldThreadTest("t1"));
//        Thread t2 = new Thread(new YieldThreadTest("t2"));
//        Thread t3 = new Thread(new YieldThreadTest("t3"));
//        t1.start();
//        t2.start();
//        t3.start();
        FutureTask<String> future = new FutureTask<>(new CallableTest());
        Thread t1 = new Thread(future);
        t1.start();
        System.out.println(future.get());
    }
}
