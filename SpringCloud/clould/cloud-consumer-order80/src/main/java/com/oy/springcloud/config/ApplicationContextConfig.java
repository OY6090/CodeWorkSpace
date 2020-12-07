package com.oy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author OY
 * @Date 2020/10/7
 */

@Configuration
public class ApplicationContextConfig {

    /**
     * 负载均衡
     *
     * @return
     */
   // @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
