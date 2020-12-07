package com.oy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author OY
 * @Date 2020/10/11
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment(){
        String result = restTemplate.getForObject(INVOME_URL+"/payment/consul",String.class );
        return result;
    }
}
