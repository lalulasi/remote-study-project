package com.luojun.concurrency4;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-29 09:39
 **/
public class LockSupportTest implements Runnable{
    private Object object;


    public LockSupportTest(Object object){
        this.object = object;

    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Block info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Block info " + LockSupport.getBlocker((Thread) object));
        System.out.println("after unpark");
    }


    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest(Thread.currentThread());
        Thread t = new Thread(lockSupportTest);
        t.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("sdf");
    }
    /*
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("begin start thread name: " + Thread.currentThread().getName() + " park");
            LockSupport.park();
            System.out.println("end start thread name: " + Thread.currentThread().getName() + " park");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        System.out.println("main thread call unpark");
        LockSupport.unpark(thread);
    }*/
}
