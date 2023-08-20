package com.joker_yue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者接口
 *
 * @author Joker
 * @version 1.0
 * @date 2023/8/20 16:06
 */
@SpringBootApplication
public class AppOrder_8070 {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder_8070.class, args);
    }

    /**
     * <p> 将RestTemplate注入Spring IoC容器中 </p>
     * <p> 2023/8/20,16:29 </p>
     * @param builder
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * <p> 将AtomicInteger注入Spring IoC容器中 </p>
     * <p> 2023/8/20,17:06 </p>
     *
     * @return java.util.concurrent.atomic.AtomicInteger
     */
    @Bean
    public AtomicInteger atomicCounter() {
        return new AtomicInteger(-1);
    }
}
