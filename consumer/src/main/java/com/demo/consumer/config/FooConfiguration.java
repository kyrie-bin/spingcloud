package com.demo.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author kyrie
 * @Date 2019/12/18
 */
@Configuration
public class FooConfiguration {
    @Bean
    public IRule ribbonRule() {
        //RandomRule: 负载均衡规则: 随机
        return new RandomRule();
    }
}
