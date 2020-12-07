package com.oy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.oy.springcloud.entities.CommonResult;
import com.oy.springcloud.entities.Payment;
import com.oy.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author OY
 * @Date 2020/11/11
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200," 按 资 源 名 称 限 流 测 试 OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,"exception.getClass().getCanonicalName()+\"t 服务\n" + "不可用");
    }


    @GetMapping("rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按 url 限流测试 OK",new Payment(2020L,"serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler ="handleException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }

}
