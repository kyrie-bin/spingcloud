package com.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ABC1
 */
@SpringBootApplication(scanBasePackages = {"com.demo"})
@EnableEurekaClient //开启 eureka客户端,也可以使用@EnableDiscoveryClient注解
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
