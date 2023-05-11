package com.jun.springcloud.resource;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.model.Payment;
import com.jun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 10:15
 **/
@RestController
@Slf4j
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    
    /** 
    * @Description: create payment
    * @Param: [payment] 
    * @return: com.jun.springcloud.model.CommonResult<com.jun.springcloud.model.Payment> 
    * @Author: jun.luo 
    * @Date: 2023/5/8 
    */
    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("PaymentResource.create start payment={}", payment);
        int result = paymentService.create(payment);
        log.info("PaymentResource.create result payment={}", result);
        if (result > 0){  //成功
            return new CommonResult(200,"insert successfully serverPort: " + serverPort, result);
        }else {
            return new CommonResult<Payment>(444,"insert fail", null);
        }
    }
    
    /** 
    * @Description: find payment by id
    * @Param: [id] 
    * @return: com.jun.springcloud.model.CommonResult<com.jun.springcloud.model.Payment> 
    * @Author: jun.luo 
    * @Date: 2023/5/8 
    */
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.findPaymentById(id);
        log.info("PaymentResource.getPaymentById={}", payment);
        if (payment != null){  //说明有数据，能查询成功
            return new CommonResult<Payment>(200,"success serverPort: " + serverPort, payment);
        }else {
            return new CommonResult<Payment>(444, "can not find payment by id=" + id, null);
        }
    }
}
