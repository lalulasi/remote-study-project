package com.jun.springcloud.service.impl;

import com.jun.springcloud.dao.PaymentDao;
import com.jun.springcloud.model.Payment;
import com.jun.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 10:10
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentDao.findPaymentById(id);
    }
}
