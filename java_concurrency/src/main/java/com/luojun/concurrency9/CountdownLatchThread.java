package com.luojun.concurrency9;

import java.util.concurrent.CountDownLatch;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-04-06 11:13
 **/
public class CountdownLatchThread implements Runnable{
    private final CountDownLatch countDownLatch;

    public CountdownLatchThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " doing something");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 该线程执行完了，-1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(new CountdownLatchThread(countDownLatch), "t1");
        Thread t2 = new Thread(new CountdownLatchThread(countDownLatch), "t2");
        Thread t3 = new Thread(new CountdownLatchThread(countDownLatch), "t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Waiting for threads to finish");
        try{
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " continue");
    }

}
