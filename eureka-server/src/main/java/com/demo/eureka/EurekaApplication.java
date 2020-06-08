package com.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ABC1
 */
@SpringBootApplication(scanBasePackages = {"com.demo"})  //SpringBoot 核心配置
@EnableEurekaServer     //开启 Eureka server
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
