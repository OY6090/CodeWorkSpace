package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author OY
 * @Date 2020/11/1
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001 {
     public static void main(String[] args) {
           SpringApplication.run(PaymentMain9001.class, args);
      }
}
