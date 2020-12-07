package com.oy.springcloud.myhandler;

import com.oy.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;


/**
 * @Author OY
 * @Date 2020/11/13
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020, "自定义限流处理信息2....CustomerBlockHandler--2");
    }
}
