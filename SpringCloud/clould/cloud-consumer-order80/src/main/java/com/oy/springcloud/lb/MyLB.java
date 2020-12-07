package com.oy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author OY
 * @Date 2020/10/13
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 坐标
    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next)); // 第一个参数是期望值，第二个参数是修改值是
        System.out.println("******第几次访问，次数next:" + next + ",current:"+ current);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {// 得到机器列表

        // 获取服务器的下标位置
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
