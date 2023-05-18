package com.jun.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: netty_study
 * @description:
 * @author: jun.luo
 * @create: 2023-05-18 16:49
 **/
/*
    BIO工作流程：服务器启动一个ServerSocket
    使用BIO模型开启一个服务器，监听6666端口，当客户端有连接时，就启动一个线程与之通讯
 */
public class BIOServer {
    public static void main(String[] args) {
        // 创建一个线程池
        // 如果有客户端连接，就创建一个线程，与之通讯
        ExecutorService executors = Executors.newCachedThreadPool();

        // 创建ServerSocket
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("server start");
            while(true){
                System.out.println("Thread id=" + Thread.currentThread().getId() +
                        ", Thread name=" + Thread.currentThread().getName());
                // 监听，等待客户端连接
                System.out.println("waiting for clients");
                Socket socket = serverSocket.accept();
                System.out.println("connect to a client");

                // 创建一个线程，与之通信
                executors.execute(() -> {
                    // 客户端处理
                    handle(socket);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket socket) {
        System.out.println("Thread id=" + Thread.currentThread().getId() +
                ", Thread name=" + Thread.currentThread().getName());
        byte[] bytes = new byte[1024];
        try {
            // 通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            // 通过socket获取输入流
            while(true) {
                System.out.println("Thread id=" + Thread.currentThread().getId() +
                        ", Thread name=" + Thread.currentThread().getName());
                System.out.println("read...");
                int read = inputStream.read(bytes);
                if(read == -1){
                    break;
                }else{
                    // 输出client读取的数据
                    System.out.println(new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
