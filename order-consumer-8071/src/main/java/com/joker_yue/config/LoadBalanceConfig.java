package com.joker_yue.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/21 17:27
 */

@Configuration
public class LoadBalanceConfig {
    /**
     * <p> 使用随机算法 </p>
     * <p> 2023/8/21,17:59 </p>
     *
     * @return com.netflix.loadbalancer.RandomRule
     */

    @Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }
}
