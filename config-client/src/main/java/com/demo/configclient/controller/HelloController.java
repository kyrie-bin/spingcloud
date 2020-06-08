package com.demo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kyrie
 * @Date 2020/5/15
 */
@RestController
@RefreshScope //在要属性的配置的配置类上打上 标签@RefreshScope,否则不能自动刷新
public class HelloController {

    @Value("${notify}")
    private String notify;

    @RequestMapping("/hello")
    public String hello() {
        return notify;
    }
}
