package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author OY
 * @Date 2020/11/2
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377 {
     public static void main(String[] args) {
           SpringApplication.run(NacosConfigClientMain3377.class, args);
      }
}