package com.oy.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存信息
     */
    void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
