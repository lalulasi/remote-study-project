package com.luojun.concurrency3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-03 15:18
 **/
public class LockThreadTest2 {
    Lock lock = new ReentrantLock();    // 可重入锁

    public void method1(){
        try {
            lock.lock();
            System.out.println("LockThreadTest2.method1() invoked");
        }finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println("LockThreadTest2.method2() invoked");
        }finally {
            lock.unlock();
        }
    }
}
