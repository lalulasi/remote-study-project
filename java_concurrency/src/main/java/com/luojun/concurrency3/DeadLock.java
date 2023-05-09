package com.luojun.concurrency3;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-24 15:44
 **/
public class DeadLock {
    public static Object t1 = new Object();
    public static Object t2 = new Object();

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run(){
                synchronized (t1){
                    System.out.println("Thread1 get t1");

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }

                    synchronized (t2){
                        System.out.println("Thread1 get t2");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                synchronized (t2){
                    System.out.println("Thread2 get t2");

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }

                    synchronized (t1){
                        System.out.println("Thread2 get t1");
                    }
                }
            }
        }.start();
    }

}
