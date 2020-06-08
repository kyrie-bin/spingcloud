package com.demo.consumer.api.impl;

import com.demo.consumer.api.MyFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author kyrie
 * @Date 2020/5/14
 */
@Component
public class MyFeignClientImpl implements MyFeignClient {

    @Override
    public String provide(String name) {
        return "你好,"+name+"，访问出现错误2";
    }
}
