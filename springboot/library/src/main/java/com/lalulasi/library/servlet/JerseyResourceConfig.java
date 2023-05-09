package com.lalulasi.library.servlet;


import org.glassfish.jersey.server.ResourceConfig;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-06 12:18
 **/
public class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig(){
        packages("com.lalulasi.library.resource");
    }
}
