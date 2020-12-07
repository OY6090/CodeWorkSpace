package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author OY
 * @Date 2020/10/11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8006 {
     public static void main(String[] args) {
           SpringApplication.run(PaymentMain8006.class, args);
      }
}
