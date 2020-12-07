package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * @Author OY
 * @Date 2020/10/17
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
     public static void main(String[] args) {
           SpringApplication.run(HystrixDashboardMain9001.class, args);
      }



}
