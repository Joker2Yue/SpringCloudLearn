package com.joker_yue.springcloud.config;

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
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
