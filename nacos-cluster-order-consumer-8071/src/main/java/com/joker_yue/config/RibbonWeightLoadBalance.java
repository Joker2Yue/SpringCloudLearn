package com.joker_yue.config;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义的Ribbon权重均衡算法
 *
 * @author Joker
 * @version 1.0
 * @date 2023/8/21 20:18
 */

@Component // 确保仅在SpringIoc容器中只注入一次，去隔壁的LoadBalanceConfig看看，如果已经注入，请删除此注解
public class RibbonWeightLoadBalance extends AbstractLoadBalancerRule {
    // 原子计数器
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // 初始化配置
    }

    @Override
    public Server choose(Object key) {
        return this.choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        // 获取服务列表
        List<Server> upList = lb.getReachableServers(); // 获取正在活跃的服务器
        ArrayList<NacosServer> newNacosServers = new ArrayList<>(); // 新的Nacos集合

        // 遍历upList按照权重转载进newNacosServers
        upList.forEach((server) -> {

            // 将upList中的服务强转为NacosServer，因为 com.netflix.loadbalancer.Server中没有权重信息
            NacosServer nacosServer = (NacosServer) server;
            double weight = nacosServer.getInstance().getWeight();  // 获取权重
            for (int i = 0; i < weight; i++) {
                newNacosServers.add(nacosServer);
            }
        });
        return newNacosServers.get(atomicCounter.incrementAndGet() % newNacosServers.size());
    }
}