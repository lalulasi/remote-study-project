package com.jun.springcloud.service;

import com.jun.springcloud.model.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 10:09
 **/
public interface PaymentService {
    int create(Payment payment);
    Payment findPaymentById(@Param("id")Long id);
}
