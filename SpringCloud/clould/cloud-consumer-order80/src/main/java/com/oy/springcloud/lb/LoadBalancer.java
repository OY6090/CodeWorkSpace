package com.oy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
*@Description
*@Author OY
*@Date 2020/10/13
*@Time 23:01
*/

public interface LoadBalancer {
    /**
     * 收集服务器总共有多少台能提供服务器的机器，并放到list 里面
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
