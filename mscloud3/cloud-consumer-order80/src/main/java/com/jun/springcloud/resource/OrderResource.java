package com.jun.springcloud.resource;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 10:58
 **/
@RestController
@Slf4j
public class OrderResource {
    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://localhost:8001/rest/payment/";

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "create", payment, CommonResult.class);  //写操作
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "get/" + id, CommonResult.class);
    }
}
