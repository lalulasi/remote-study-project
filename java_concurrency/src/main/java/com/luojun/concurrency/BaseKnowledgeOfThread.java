package com.luojun.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-20 16:43
 **/
public class BaseKnowledgeOfThread {
    public static class MyThread1 implements Runnable{

        @Override
        public void run() {
            System.out.println("run my thread 1 using implementing Runnable method");
        }
    }

    public static class MyThread2 implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("run my thread 2 using implementing Callable method and return sth");
            return "result";
        }
    }

    public static class MyThread3 extends Thread{
        public void run(){
            System.out.println("run my thread 3 using extending Thread");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 启动线程1
        Thread t1 = new Thread(new MyThread1());
        t1.start();

        // 启动线程2，并获取返回值
        FutureTask<String> future = new FutureTask<>(new MyThread2());
        Thread t2 = new Thread(future);
        t2.start();
        String result = future.get();
        System.out.println(result);

        // 启动线程3
        Thread t3 = new Thread(new MyThread3());
        t3.start();
    }
}
