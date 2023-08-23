package com.joker_yue.service.order.impl;

import com.joker_yue.service.order.impl.openfeign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 17:26
 */
@RestController
public class OrderService {
    // 得到Feign客户端
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    /**
     * <p> 基于openfeign客户端实现RPC远程调用 </p>
     * <p> 2023/8/23,17:27 </p>
     *
     * @return java.lang.String
     */
    @RequestMapping("/orderFeignToMember")
    public String orderFeignToMember() {
        String result = memberServiceFeign.getUser(1);
        return "我是订单服务调用会员服务的接口，返回这个结果"+result;
    }
}
