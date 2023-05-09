package com.jun.springcloud.dao;

import com.jun.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: mscloud3
 * @description: payment mybatis dao use mapper annotation
 * @author: jun.luo
 * @create: 2023-05-08 09:44
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment findPaymentById(@Param("id")Long id);
}
