package com.oy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author OY
 * @Date 2020/10/11
 */
@Configuration
public class ApplicationConfig {

    @LoadBalanced // 负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
