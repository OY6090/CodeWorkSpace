package com.oy.springcloud.service.Impl;

import com.oy.springcloud.dao.OrderDao;
import com.oy.springcloud.domain.Order;
import com.oy.springcloud.service.AccountService;
import com.oy.springcloud.service.OrderService;
import com.oy.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author OY
 * @Date 2020/11/16
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        //新建订单
        orderDao.create(order);
        //扣减库存
        log.info("----->订单微服务开始调用库存， 做扣减 Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存， 做扣减 end");

        //扣减账户
        log.info("----->订单微服务开始调用账户， 做扣减 Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户， 做扣减 end");
        //修改订单状态， 从零到 1 代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束了");
    }
}
