package com.joker_yue.service.order.impl.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 17:30
 */
@FeignClient("microservice-member")    // 定义为Feign客户端
public interface MemberServiceFeign {
    @GetMapping("/getUser")
    String getUser (@RequestParam("userId") Integer userId);
}
