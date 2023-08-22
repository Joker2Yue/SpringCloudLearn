package com.joker_yue.loadbalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/21 13:58
 */
@Component
public class WeightLoadBalance implements MyLoadBalance {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private AtomicInteger atomicCounter;    // 计数器

    @Override
    public ServiceInstance getInstances(String serviceName) {
        // 1. 根据服务的id名称，获取该服务的多个实例
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if (instances == null || instances.size() == 0) {
            return null;
        }

        // 2. 配置权重
        ArrayList<ServiceInstance> newInstances = new ArrayList<>();    // 新的实例集
        // 循环遍历该服务名称的多个实例
        instances.forEach((services) -> {
            // 获取该实例的权重
            Double weight = Double.parseDouble(services.getMetadata().get("nacos.weight"));
            // 按照权重，将其装载进新的实例集
            for (int i = 0; i < weight; i++) {
                newInstances.add(services);
            }
        });

        // 3. 使用轮询的算法，遍历新的实例集并返回实例
        atomicCounter.incrementAndGet();    // 计数器自加
        return newInstances.get(atomicCounter.get() % newInstances.size());
    }
}
