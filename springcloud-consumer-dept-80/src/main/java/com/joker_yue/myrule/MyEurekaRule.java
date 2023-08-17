package com.joker_yue.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/17 19:52
 */

@Configuration
public class MyEurekaRule {

    // 自定义负载均衡算法
    // IRule
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilterRule：轮询，但是会过滤掉不可用的服务
    // Retry：会先按照轮询获取服务，如果服务获取失败，将会在指定的时间内重试
    @Bean
    public IRule myRule() {
        // 随机
        // return new RandomRule();     // 用别人的
        return new MyRandomRule();      // 用自己的
    }

}
