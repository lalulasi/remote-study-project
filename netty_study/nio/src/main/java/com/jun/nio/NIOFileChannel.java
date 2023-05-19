package com.jun.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @program: netty_study
 * @description:
 * @author: jun.luo
 * @create: 2023-05-19 17:22
 **/
public class NIOFileChannel {
    public static void main(String[] args) throws IOException {
        String str = "Hello World";
        FileOutputStream fileOutputStream = null;
        try {
            // 创建一个输入流
            fileOutputStream = new FileOutputStream("D://test.txt");
            FileChannel fileChannel = fileOutputStream.getChannel();
            // 创建一个byteBuffer缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 将str放入byteBuffer
            byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
            // 重置byteBuffer position
            byteBuffer.flip();
            // 将byteBuffer数据写入fileChannel
            fileChannel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            assert fileOutputStream != null;
            fileOutputStream.close();
        }
    }
}
