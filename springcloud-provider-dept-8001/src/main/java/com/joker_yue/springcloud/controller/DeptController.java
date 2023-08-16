package com.joker_yue.springcloud.controller;

import com.joker_yue.springcloud.pojo.Dept;
import com.joker_yue.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    private DiscoveryClient client; // 获取一些配置的信息，得到具体的微服务

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.queryAll();
    }

    // 获取进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获得微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services: " + services);

        // 得到一个具体的微服务的信息，通过具体的微服务id
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept8001");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId()
            );
        }
        return this.client;
    }
}
