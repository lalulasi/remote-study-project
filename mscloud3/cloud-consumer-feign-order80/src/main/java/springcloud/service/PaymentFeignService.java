package springcloud.service;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-17 11:01
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/rest/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping(value = "/rest/payment/feign/timeout")
    String paymentFeignTimeout();
}
