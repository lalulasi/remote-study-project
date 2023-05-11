package com.jun.springcloud.resource;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 10:58
 **/
@RestController
@Slf4j
public class OrderConsulResource {
    public static final String INVOME_URL = "http://consul-provider-payment/rest/payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String payment (){
        return restTemplate.getForObject(INVOME_URL+"consul",String.class);
    }
}
