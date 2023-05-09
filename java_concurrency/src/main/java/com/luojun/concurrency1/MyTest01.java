package com.luojun.concurrency1;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-02-24 20:37
 **/
public class MyTest01 {
    public synchronized void test1() throws InterruptedException {
        System.out.println("test1() start");
        Thread.sleep(10000);
        System.out.println("test1() end");
    }

    public static synchronized void test2() throws InterruptedException {
        System.out.println("test2() start");
        Thread.sleep(5000);
        System.out.println("test2() end");
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable addThread = () -> {
            for(int i =0; i<30; i++){
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    counter.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable minusThread = () -> {
            for(int i = 0; i < 30; i++){

                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    counter.minus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(addThread);
        t1.start();
        Thread t2 = new Thread(minusThread);
        t2.start();
    }

}
