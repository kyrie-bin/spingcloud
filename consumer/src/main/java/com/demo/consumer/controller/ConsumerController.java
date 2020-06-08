package com.demo.consumer.controller;

import com.demo.consumer.api.MyFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author kyrie
 * @Date 2019/12/16
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MyFeignClient myFeignClient;

    //@HystrixCommand: 给方法启用熔断器功能,当出现访问故障,自动调用fallbackMethod指向的方法
    @RequestMapping("/consumer")
    @HystrixCommand(fallbackMethod = "errorMethod") //开启熔断器功能
    public String consumer(@RequestParam("name") String name) {
        //执行http请求Producer服务的provide映射地址，返回的数据为字符串类型
        //PRODUCER：提供者(Producer服务)的注册服务ID
        //provide ：消费方法
        String result = restTemplate.getForObject("http://PRODUCER/provider?name=" + name, String.class);
        return result;
    }

    public String errorMethod(String name) {
        return "你好, " + name + ", 访问错误1";
    }

    @RequestMapping("/feign")
    public String feignTest(@RequestParam("name") String name) {
        return myFeignClient.provide(name);
    }


}
