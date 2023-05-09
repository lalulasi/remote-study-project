package com.luojun.concurrency3;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-03 14:30
 **/
public class MyTest {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void myMethod1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("myMethod1 invoked");
            }
        }
    }

    public void myMethod2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("myMethod2 invoked");
            }
        }
    }

    public static void main(String[] args) {
        MyTest myTest6 = new MyTest();

        Runnable runnable1 = () -> {
            while (true) {
                myTest6.myMethod1();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {

                }
            }
        };

        Thread thread1 = new Thread(runnable1, "myThread1");

        Runnable runnable2 = () -> {
            while (true) {
                myTest6.myMethod2();

                try {
                    Thread.sleep(220);
                } catch (InterruptedException ex) {

                }
            }
        };

        Thread thread2 = new Thread(runnable2, "myThread2");

        thread1.start();
        thread2.start();
    }

}
