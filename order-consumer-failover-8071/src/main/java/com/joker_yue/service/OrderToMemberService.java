package com.joker_yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
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

    /**
     * 订单服务调用到我们的会员服务接口
     *
     * @return
     */
    @RequestMapping("/orderToMember")
    public Object orderToMemberFailover() {
        // 1.根据服务名称从 注册中心获取集群列表地址，并将第0个进行使用
        List<ServiceInstance> instances = discoveryClient.getInstances("member-producer-808x");

        // 2.遍历每一个服务实例
        for (int i = 0; i < instances.size(); i++) {
            try {
                ServiceInstance serviceInstance = instances.get(i);
                String memberUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getMember";
                return "订单服务调用会员服务" + restTemplate.getForObject(memberUrl, String.class);
            } catch (RestClientException e) {
                System.err.println("[RPC远程调用发生故障]" + e.getMessage());
            }
        }
        return "fail";
    }

}
