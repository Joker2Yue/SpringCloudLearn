package com.joker_yue.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

/**
 * 自定义负载均衡算法-接口
 * @author Joker
 * @version 1.0
 * @date 2023/8/20 16:53
 */
public interface MyLoadBalance {
    ServiceInstance getInstances(String serviceName);
}
