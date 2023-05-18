package com.jun.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-18 10:59
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
