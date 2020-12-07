package com.springcloud.Service.impl;

import com.oy.springcloud.entities.CommonResult;
import com.oy.springcloud.entities.Payment;
import com.springcloud.Service.PaymentService;
import org.springframework.stereotype.Component;;

/**
 * @Author OY
 * @Date 2020/11/13
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444," 服 务 降 级 返 回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
