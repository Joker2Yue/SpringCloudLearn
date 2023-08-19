package com.joker_yue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 21:00
 */
// 启动类
@SpringBootApplication
@EnableEurekaClient // 在服务启动后自动将服务端注册到Eureka
@EnableDiscoveryClient  // 服务发现
public class DeptConfigProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConfigProvider_8001.class, args);
    }
}
