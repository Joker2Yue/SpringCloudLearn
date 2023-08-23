package com.joker_yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public Object orderToMember() {
        // 要获取的服务链接
        String memberUrl = "http://" + "member-producer-808x" + "/getMember";
        return "订单服务调用会员服务" + restTemplate.getForObject(memberUrl, String.class);
    }

}
