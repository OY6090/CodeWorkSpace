package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author OY
 * @Date 2020/11/8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {
     public static void main(String[] args) {
           SpringApplication.run(MainApp8401.class, args);
      }
}