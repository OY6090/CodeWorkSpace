package com.oy.springcloud.service.impl;

import com.oy.springcloud.dao.PaymentDao;
import com.oy.springcloud.entities.Payment;
import com.oy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Author OY
 * @Date 2020/10/7
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource // @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
