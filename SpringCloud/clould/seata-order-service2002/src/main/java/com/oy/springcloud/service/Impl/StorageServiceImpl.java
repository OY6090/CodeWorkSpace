package com.oy.springcloud.service.Impl;

import com.oy.springcloud.dao.StorageDao;
import com.oy.springcloud.domain.Storage;
import com.oy.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service 中扣减库存开始");
        storageDao.decrease(productId, count);
        LOGGER.info("------->storage-service 中扣减库存结束");
    }
}
