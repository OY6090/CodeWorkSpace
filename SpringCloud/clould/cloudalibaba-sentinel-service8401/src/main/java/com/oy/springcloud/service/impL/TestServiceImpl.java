package com.oy.springcloud.service.impL;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.oy.springcloud.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author OY
 * @Date 2020/11/8
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @SentinelResource("message")
    public void message() {
        System.out.println("message");
    }
}
