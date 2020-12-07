package com.oy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.oy.springcloud.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author OY
 * @Date 2020/11/8
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private TestService testService;

    @GetMapping("/testA")
    public String testA(){
       // testService.message();
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
       // testService.message();
        return "----testB";
    }

    /**
     * RT
     * @return
     */
    @GetMapping(value = "/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("TestD 测试 RT");

        return "-----testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 异常比例");
        int age = 10/0;
        return "------testE";
    }

    @GetMapping("/testF")
    public String testF(){
        log.info("testF 测试异常数");
        int age = 10/0;
        return "------testF 测试异常数";
    }

    /**
     *  热点 key 限流
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2){
        return "----testHotKey";
    }

    /**
     * 兜底方法
     */
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "-----deal_testHotKey,o(╥﹏╥)o";
    }
}
