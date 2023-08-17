package com.joker_yue.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/16 14:39
 */

@Configuration
public class ConfigBean {   //@Configuration 注解 相当于applicationContext.xml
    // 配置负载均衡实现RestTemplate

    @Bean
    @LoadBalanced   // Ribbon负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
