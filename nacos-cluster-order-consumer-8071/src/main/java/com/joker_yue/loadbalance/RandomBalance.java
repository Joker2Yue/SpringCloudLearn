package com.joker_yue.loadbalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/20 19:31
 */
@Component
public class RandomBalance implements MyLoadBalance {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public ServiceInstance getInstances(String serviceName) {
        // 1. 根据服务名称获取服务的集群地址列表
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        // 2. 判断是否为空
        if (instances == null || instances.size() == 0) {
            return null;
        }
        // 3. 使用负载均衡的算法
        int index = new Random().nextInt(instances.size()); // 生成从0到instances.size()-1的随机数
        return instances.get(index);

    }
}
