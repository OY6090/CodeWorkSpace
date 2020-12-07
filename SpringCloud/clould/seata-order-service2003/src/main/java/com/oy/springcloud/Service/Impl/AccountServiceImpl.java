package com.oy.springcloud.Service.Impl;

import com.oy.springcloud.Service.AccountService;
import com.oy.springcloud.dao.AccountDao;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


/**
 * @Author OY
 * @Date 2020/11/17
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    //@GlobalTransactional
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service 中扣减账户余额开始");
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service 中扣减账户余额结束");
    }
}
