package com.oy.springcloud.Service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author OY
 * @Date 2020/11/17
 */
public interface AccountService {

    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
