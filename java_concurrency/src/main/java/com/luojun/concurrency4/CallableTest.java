package com.luojun.concurrency4;

import java.util.concurrent.Callable;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-31 13:33
 **/
public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Test start..");
        Thread.sleep(5000);
        System.out.println("Test end..");
        return "success";
    }
}
