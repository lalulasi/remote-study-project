package com.luojun.concurrency9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-04-06 10:54
 **/
public class CyclicBarrierMyThread implements Runnable{
    private CyclicBarrier cb;

    public CyclicBarrierMyThread(CyclicBarrier cb){
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, ()->{
            System.out.println(Thread.currentThread().getName() + " barrier action");
        });

        Thread t1 = new Thread(new CyclicBarrierMyThread(cb), "t1");
        Thread t2 = new Thread(new CyclicBarrierMyThread(cb), "t2");
        Thread t3 = new Thread(new CyclicBarrierMyThread(cb), "t3");
        t1.start();
        t2.start();
        t3.start();
//        System.out.println(Thread.currentThread().getName() + " going to await");
//        cb.await();
//        System.out.println(Thread.currentThread().getName() + " continue");
    }
}
