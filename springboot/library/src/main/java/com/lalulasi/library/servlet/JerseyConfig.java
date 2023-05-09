package com.lalulasi.library.servlet;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import javax.ws.rs.core.Application;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-06 12:03
 **/
@Configuration
public class JerseyConfig {

    @Bean
    public ServletRegistrationBean<Servlet> jerseyServlet(){
        // 注册servlet
        ServletRegistrationBean<Servlet> registrationBean =
                new ServletRegistrationBean<>(new ServletContainer(), "/rest/*");
        registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyResourceConfig.class.getName());
        return registrationBean;
    }
}
