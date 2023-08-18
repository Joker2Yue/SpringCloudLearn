package com.joker_yue.springcloud.controller;

import com.joker_yue.springcloud.pojo.Dept;
import com.joker_yue.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供Restful服务
 *
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 20:12
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGetDept")    // 出错调用
    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("该ID:" + id + "不存在该Dept或信息无法找到");
        }
        return dept;
    }

    // 备选方案
    public Dept hystrixGetDept(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("该ID:" + id + "不存在该Dept或信息无法找到")
                .setDb_source("no this database in MySQL");
    }


}
