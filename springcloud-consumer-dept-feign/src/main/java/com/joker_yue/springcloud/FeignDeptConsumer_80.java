package com.joker_yue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/16 14:54
 */
@SpringBootApplication
@EnableEurekaClient // 开启eureka
@EnableFeignClients(basePackages = "com.joker_yue.springcloud") // 扫描Feign
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }
}
