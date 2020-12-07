package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.oy.springcloud.entities.CommonResult;
import com.oy.springcloud.entities.Payment;
import com.springcloud.Service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author OY
 * @Date 2020/11/13
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback 只负责业务异常
    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责 sentinel 控制台配置违规
    //@SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL +"/paymentSQL/"+id, CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该 ID 没有对应记录,空指针异常");
        }
        return result;
    }

    //fallback
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444," 兜 底 异 常 handlerFallback,exception 内 容 "+e.getMessage(),payment);
    }
    //blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel 限 流 , 无 此 流 水 : blockException "+blockException.getMessage(),payment);
    }


    // OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}
