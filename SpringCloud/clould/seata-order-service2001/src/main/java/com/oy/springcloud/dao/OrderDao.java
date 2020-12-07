package com.oy.springcloud.dao;

import com.oy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@Mapper
public interface OrderDao {

    // 新建订单
    void create(Order order);

    // 修改订单状态，从零开始
    void update(@Param("userId")Long userId, @Param("status") Integer status);
}
