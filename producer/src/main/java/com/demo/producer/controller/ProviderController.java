package com.demo.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kyrie
 * @Date 2019/12/16
 */
@RestController
public class ProviderController {

    @RequestMapping("/provider")
    public String provider(@RequestParam("name") String name){
        return name + "你好呀这里是producer服务";
    }
}
