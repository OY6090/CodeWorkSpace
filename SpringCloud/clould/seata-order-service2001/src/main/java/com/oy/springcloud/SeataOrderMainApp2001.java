package com.oy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源自动创建的配置
public class SeataOrderMainApp2001 {
     public static void main(String[] args) {
           SpringApplication.run(SeataOrderMainApp2001.class, args);
      }
}
