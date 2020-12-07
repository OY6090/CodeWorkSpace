package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author OY
 * @Date 2020/10/8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
     public static void main(String[] args) {
           SpringApplication.run(EurekaMain7002.class, args);
      }
}
