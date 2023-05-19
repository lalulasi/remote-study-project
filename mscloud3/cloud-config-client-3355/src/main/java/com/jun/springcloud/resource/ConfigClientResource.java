package com.jun.springcloud.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-19 09:53
 **/
@RestController
public class ConfigClientResource {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
