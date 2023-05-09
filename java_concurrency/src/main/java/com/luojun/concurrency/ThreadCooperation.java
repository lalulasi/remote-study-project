package com.luojun.concurrency;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-22 15:56
 **/
public class ThreadCooperation {
    public static class ThreadA implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("ThreadA execute start");
                Thread.sleep(4000);
                System.out.println("ThreadA execute end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadB implements Runnable{
        private Thread threadA;

        public ThreadB(Thread threadA){
            this.threadA = threadA;
        }

        @Override
        public void run() {
            System.out.println("ThreadB execute start");
            try {
                Thread.sleep(1000);
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadB execute end");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB(t1));
        t2.start();
        t1.start();
    }
}
