package com.oy.springcloud;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author OY
 * @Date 2020/10/18
 */
public class GatewayTest {

    @Test
    public void test1(){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj); // 2020-10-18T10:35:52.127+08:00[Asia/Shanghai]

        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/Denver"));// 用指定时区获取当前时间
        System.out.println(zny); // 2020-10-17T20:38:37.693-06:00[America/Denver]
    }
}
