package com.jun.springcloud.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-11 11:10
 **/
@RestController
@Slf4j
public class OrderZKResource {
    public static final String INVOME_URL = "http://cloud-provider-payment/rest/payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String payment (){
        return restTemplate.getForObject(INVOME_URL + "zk",String.class);
    }
}
