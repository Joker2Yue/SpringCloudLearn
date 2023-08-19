package com.joker_yue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/19 13:35
 */
@SpringBootApplication
@EnableZuulProxy    // 开启Zuul
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }
}
