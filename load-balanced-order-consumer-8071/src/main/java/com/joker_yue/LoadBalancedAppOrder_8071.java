package com.joker_yue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
public class LoadBalancedAppOrder_8071 {
    public static void main(String[] args) {
        SpringApplication.run(LoadBalancedAppOrder_8071.class, args);
    }

    /**
     * <p> 将RestTemplate注入Spring IoC容器中 </p>
     * <p> 2023/8/20,16:29 </p>
     * @param builder
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
