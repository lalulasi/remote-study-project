package com.jun.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-18 09:53
 **/
@Service
public class PaymentService {
    //成功
    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() +
                " paymentInfo_OK, id = " + id + "\t" + "哈哈哈";
    }

    //失败
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }
}
