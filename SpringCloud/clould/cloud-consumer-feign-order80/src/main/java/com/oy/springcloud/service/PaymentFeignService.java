package com.oy.springcloud.service;

import com.oy.springcloud.entities.CommonResult;
import com.oy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
*@Description
*@Author OY
*@Date 2020/10/15
*@Time 23:07
*/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
