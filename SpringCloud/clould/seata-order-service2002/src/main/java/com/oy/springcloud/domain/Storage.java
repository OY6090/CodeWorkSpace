package com.oy.springcloud.domain;

import lombok.Data;

/**
 * @Author OY
 * @Date 2020/11/16
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    // 总库存
    private Integer total;

    // 已用库存
    private Integer used;

    // 剩余库存
    private Integer residue;
}
