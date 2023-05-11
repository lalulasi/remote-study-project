package com.jun.springcloud.resource;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-11 11:31
 **/
@RestController
@Slf4j
public class PaymentResource {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consul")
    public String paymentConsul(){
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID();
    }
}
