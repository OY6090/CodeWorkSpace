package com.oy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author OY
 * @Date 2020/11/2
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configinfo;

    @GetMapping("/config/info")
    public String getConfiginfo(){
       return configinfo;
    }
}
