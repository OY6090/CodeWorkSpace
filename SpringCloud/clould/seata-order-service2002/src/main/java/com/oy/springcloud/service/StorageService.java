package com.oy.springcloud.service;

/**
 * @Author OY
 * @Date 2020/11/16
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
