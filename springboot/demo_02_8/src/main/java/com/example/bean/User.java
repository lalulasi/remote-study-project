package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-10 09:16
 **/
@Component
@ConfigurationProperties(prefix="user")
public class User {
    private String userId;
    private String name;
}
