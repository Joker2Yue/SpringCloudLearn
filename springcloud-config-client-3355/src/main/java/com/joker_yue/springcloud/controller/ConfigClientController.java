package com.joker_yue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/19 19:02
 */
@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName:" + applicationName + ",eurekaServer:" + eurekaServer + ",port:" + port;
    }
}
