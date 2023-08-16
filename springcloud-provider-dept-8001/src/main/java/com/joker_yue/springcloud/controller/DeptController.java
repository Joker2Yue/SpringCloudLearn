package com.joker_yue.springcloud.controller;

import com.joker_yue.springcloud.pojo.Dept;
import com.joker_yue.springcloud.service.DeptService;
import com.joker_yue.springcloud.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提供Restful服务
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 20:12
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.queryAll();
    }
}
