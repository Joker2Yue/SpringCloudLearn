package com.joker_yue.service.member.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 会员API接口
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 16:48
 */
public interface MemberService {
    /**
     * <p> 提供发布的接口 </p>
     * <p> 2023/8/23,16:49 </p>
     * @param id
     * @return java.lang.String
     */

    @GetMapping("/getUser")
    String getUser(Integer id);
}
