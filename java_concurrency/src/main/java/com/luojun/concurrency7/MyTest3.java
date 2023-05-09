package com.luojun.concurrency7;


/*
    ThreadLocal

    本质上，ThreadLocal是通过空间来换取时间，从而实现每个线程当中都会有一个变量的副本，这样每个线程就都会操作该副本，从而完全
    规避了多线程的并发问题。

    Java中存在四种类型的引用：

    1. 强引用(strong)  new XXX() 无论如何都不会被垃圾回收
    2. 软引用(soft)    当内存空间不够时，会将软引用指向的对象清理
    3. 弱引用(weak)    在下一次垃圾回收时，会被清理
    4. 虚引用(phantom) 并不表示指向一个对象
    除了强引用之外 其他引用都需要继承父类Reference

    public class Test{
        private static final ThreadLocal<String> tl = new ThreadLocal();
    }

    try {
        ...
        ...
        ...


    } finally {
        tl.remove();
    }

 */

public class MyTest3 {

    private static final ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        try{
            ThreadLocal<String> threadLocal = new ThreadLocal<>();

            threadLocal.set("hello world");

            System.out.println(threadLocal.get());

            threadLocal.set("welcome");

            System.out.println(threadLocal.get());
        }finally {
            tl.remove();
        }
    }
}
