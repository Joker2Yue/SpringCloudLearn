package com.joker_yue.service.member.api.impl;

import com.joker_yue.service.member.api.MemberService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现会员API接口
 * @author Joker
 * @version 1.0
 * @date 2023/8/23 17:01
 */
@RestController
public class MemberServiceImpl implements MemberService {
    /**
     * <p> 在此处不需要加注解@GetMapping，因为继承过来的话注解也会继承过来 </p>
     * <p> 2023/8/23,17:02 </p>
     * @param id
     * @return java.lang.String
     */
    @Override
    public String getUser(Integer id) {
        return "我是会员服务";
    }
}
