package com.joker_yue.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

import javax.swing.*;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 17:36
 */
@SpringBootApplication
@EnableFeignClients // 开启feign客户端
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
