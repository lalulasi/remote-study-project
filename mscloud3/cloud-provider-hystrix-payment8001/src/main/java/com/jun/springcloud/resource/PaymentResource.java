package com.jun.springcloud.resource;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-18 09:55
 **/
@Controller
@Slf4j
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public CommonResult<String> paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:" + result);
        return new CommonResult<>(200, result);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public CommonResult<String> paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*******result:" + result);
        return new CommonResult<>(200, result);
    }
}
