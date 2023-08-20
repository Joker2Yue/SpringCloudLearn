package com.joker_yue.service;

import com.joker_yue.loadbalance.RoundLoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Joker
 */
@RestController
public class OrderToMemberService {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RoundLoadBalance roundLoadBalance;

    /**
     * 订单服务调用到我们的会员服务接口
     *
     * @return
     */
    @RequestMapping("/orderToMember")
    public Object orderToMember() {
        // 1.根据服务名称从 注册中心获取集群列表地址，并将第0个进行使用
        // List<ServiceInstance> instances = discoveryClient.getInstances("member-producer-808x");
        // ServiceInstance serviceInstance = instances.get(0);

        // 将获取服务实例的规则搭配上负载均衡算法
        ServiceInstance serviceInstance = roundLoadBalance.getInstances("member-producer-808x");

        // 会员服务的IP和端口
        String memberUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getMember";

        return "订单服务调用会员服务" + restTemplate.getForObject(memberUrl, String.class);
    }

}
