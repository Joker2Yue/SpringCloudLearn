package com.joker_yue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/16 14:54
 */
@SpringBootApplication
@EnableEurekaClient // 开启eureka
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
