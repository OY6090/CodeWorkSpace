package com.oy.springcloud.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@Configuration
@MapperScan({"com.oy.springcloud.dao"})
public class MyBatisConfig {
}
