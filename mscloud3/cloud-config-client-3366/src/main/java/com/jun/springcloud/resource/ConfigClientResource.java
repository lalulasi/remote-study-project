package com.jun.springcloud.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-19 11:08
 **/
@RestController
@RefreshScope
public class ConfigClientResource {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
    }
}
