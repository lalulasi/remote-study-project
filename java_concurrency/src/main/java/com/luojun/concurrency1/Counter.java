package com.luojun.concurrency1;

import java.math.BigDecimal;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-02-28 14:20
 **/
public class Counter {
    private int counter = 0;
    Object[] items = new Object[100];
    public synchronized void add() throws InterruptedException {
        while(counter != 0){
            wait();         // 当add被notify唤醒时，会先进行counter的判断，如果因其他线程唤满足了满段条件，会继续执行wait()等待
        }
        counter++;
        System.out.print(counter);
        notify();
    }

    public synchronized void minus() throws InterruptedException {
        while(counter != 1){
            wait();
        }
        counter--;
        System.out.print(counter);
        notify();
    }
}
