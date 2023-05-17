package springcloud.resource;

import com.jun.springcloud.model.CommonResult;
import com.jun.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.PaymentFeignService;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-17 11:08
 **/
@RestController
@Slf4j
public class OrderFeignResource {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String getPaymentById(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
