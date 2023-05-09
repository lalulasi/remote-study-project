package com.luojun.concurrency5;


/*
    CountDownLatch
 */

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class MyTest1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3); // 实际执行子任务的数量

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(2000);

                System.out.println("hello");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                countDownLatch.countDown(); // 计数器以原子的f方式-1，直到为0
            }
        }).start());

        System.out.println("启动子线程完毕");

        try {
            countDownLatch.await();
            // 1.检查countdown计数器值是否为0，如果不为0则该线程进入阻塞状态，等待被唤醒
            // countDownLatch.await(200, TimeUnit.MILLISECONDS); 如果超过设定时间，主线程会继续向下执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕");
    }
}



