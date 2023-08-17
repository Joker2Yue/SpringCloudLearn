package com.joker_yue.springcloud.service;

import com.joker_yue.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Feign客户端的配置
 *
 * @author Joker
 * @version 1.0
 * @date 2023/8/17 21:02
 */
// 参数：服务名
@Component  // 为了能够注入Spring
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")   // 可以被服务直接调用
public interface DeptClientService {
    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);
}
