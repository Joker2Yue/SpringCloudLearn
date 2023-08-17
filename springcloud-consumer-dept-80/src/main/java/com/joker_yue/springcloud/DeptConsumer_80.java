package com.joker_yue.springcloud;

import com.joker_yue.myrule.MyEurekaRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/16 14:54
 */
@SpringBootApplication
@EnableEurekaClient // 开启eureka
// 在微服务启动的时候就能够加载我们自定义的ribbon类
// name应该与微服务的名字一致，
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = MyEurekaRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
