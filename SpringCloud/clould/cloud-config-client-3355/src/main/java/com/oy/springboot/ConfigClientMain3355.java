package com.oy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author OY
 * @Date 2020/10/19
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
     public static void main(String[] args) {
           SpringApplication.run(ConfigClientMain3355.class, args);
      }
}
