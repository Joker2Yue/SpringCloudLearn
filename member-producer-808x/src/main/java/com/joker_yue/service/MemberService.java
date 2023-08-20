package com.joker_yue.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员服务接口
 * @author Joker
 * @version 1.0
 * @date 2023/8/20 14:17
 */
@RestController
public class MemberService {
    /**
     * <p> 为会员服务提供接口 </p>
     * <p> 2023/8/20,14:21 </p>
     *
     * @return java.lang.String
     */

    @RequestMapping("/getMember")
    public String getMember(){
        return "我是会员服务接口...";
    }
}
