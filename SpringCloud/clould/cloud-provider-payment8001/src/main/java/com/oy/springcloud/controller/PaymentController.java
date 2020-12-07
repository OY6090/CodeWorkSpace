package com.oy.springcloud.controller;

import com.oy.springcloud.entities.CommonResult;
import com.oy.springcloud.entities.Payment;
import com.oy.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @Author OY
 * @Date 2020/10/7
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 服务发现，获取服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果： " + result);

        // 成功
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("*****查询结果： " + payment);

        // 成功
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort"+serverPort, payment);
        } else {
            return new CommonResult(444, "没 有 对 应 记 录 ， 查 询 ID ："+id, null);
        }
    }

    /**
     * 服务发现
     * @return discoveryClient
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("**** element:"+ element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     * 设置超时
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }


    // ====================> zipkin+sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
