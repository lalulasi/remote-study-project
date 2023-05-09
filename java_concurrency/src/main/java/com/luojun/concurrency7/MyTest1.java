package com.luojun.concurrency7;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyTest1 {


    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            System.out.println("pre execution");

            Thread.sleep(5000);

            int randomNumber = new Random().nextInt(500);

            System.out.println("post execution");

            return randomNumber;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        System.out.println("thread has started");

        try {
            Thread.sleep(2000);
            // 抛出Timeout异常，但子线程依然会继续执行，只是没办法拿到返回值
            // System.out.println(futureTask.get(1, TimeUnit.MILLISECONDS));
            System.out.println(futureTask.get());
            // 主程序停止2s，子线程停止5s，主线程get方法阻塞等待结果返回
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
