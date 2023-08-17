package com.joker_yue.springcloud.controller;

import com.joker_yue.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/16 14:32
 */
@RestController
public class DeptConsumerController {
    // 理解：消费者，不应该有service层

    // RestTemplate ... 供我们直接调用就可以。我们需要将其注册到Spring中
    // 它的存在是为了给我们提供多种便捷访问http服务的方法。是简单的restful服务模板
    // 从哪里拿，用什么方式拿，拿什么东西。url, 实体（使用Map封装）, Class<T> responseType
    @Autowired
    private RestTemplate restTemplate;

    // 做负载均衡我们不应该写死指定的http请求，应该spring.application.name
    // private static final String REST_URL_PREFIX = "http://localhost:8001";// 请求的地址常量
    // 主机名找不到的删除这个包spring-cloud-starter-netflix-ribbon，新版的自带负载均衡，删不掉的想办法删除，用这个就会出错
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        // getForObject()  请求方式：get，返回的是Object
        // 括号内的参数：url,  Class<T> responseType
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        // 括号内的参数：url, 实体（使用Map封装）, Class<T> responseType
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
