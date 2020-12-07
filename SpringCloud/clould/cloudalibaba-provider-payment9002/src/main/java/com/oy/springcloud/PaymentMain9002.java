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
public class PaymentMain9002 {
     public static void main(String[] args) {
           SpringApplication.run(PaymentMain9002.class, args);
      }
}
