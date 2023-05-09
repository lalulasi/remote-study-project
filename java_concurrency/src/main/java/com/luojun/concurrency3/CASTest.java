package com.luojun.concurrency3;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-28 11:13
 **/
public class CASTest {
    private AtomicInteger i = new AtomicInteger(0);
    AtomicReference<List> listAtomicReference = new AtomicReference<>();


    public Integer addAndGet(){
        return i.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[] { 0, 0 });
        array.getAndSet(0, 5);
        System.out.println(array);
    }
}
