package com.oy.springcloud.service;

import com.oy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author OY
 * @Date 2020/10/7
 */
public interface PaymentService {

    public int create(Payment payment); // 写

    public Payment getPaymentById(@Param("id") Long id); // 读取
}
