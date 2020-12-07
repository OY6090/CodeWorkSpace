package com.oy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author OY
 * @Date 2020/10/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private  T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
