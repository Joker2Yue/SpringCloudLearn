package com.joker_yue.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 21:00
 */
// 启动类
@SpringBootApplication
@EnableEurekaClient // 在服务启动后自动将服务端注册到Eureka
@EnableDiscoveryClient  // 服务发现
// @EnableCircuitBreaker   // 熔断支持
@EnableHystrix      // 开启Hystrix，已经实现了@EnableCircuitBreaker
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    // 增加一个Servlet，用于发送监控数据。以方便Dashboard监控到
    @Bean
    public ServletRegistrationBean getServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;

    }
}
