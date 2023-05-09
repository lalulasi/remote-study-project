package com.luojun.concurrency;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-20 17:11
 **/
public class DaemonThread implements Runnable{


    @Override
    public void run() {
        try {
            while(true){
                System.out.println("send message every 1s");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            System.out.println("sub thread finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DaemonThread());
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(2000);
        System.out.println("finish the main task");
    }
}
