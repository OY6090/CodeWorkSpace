package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author OY
 * @Date 2020/10/17
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
     public static void main(String[] args) {
           SpringApplication.run(GateWayMain9527.class, args);
      }
}
