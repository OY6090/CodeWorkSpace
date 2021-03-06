package com.oy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author OY
 * @Date 2020/11/17
 */
@Configuration
@MapperScan({"com.oy.springcloud.dao.AccountDao"})
public class MyBatisConfig {
}
