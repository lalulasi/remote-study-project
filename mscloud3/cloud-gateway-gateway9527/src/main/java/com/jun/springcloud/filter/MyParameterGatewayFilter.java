package com.jun.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-18 11:23
 **/
@Component
@Slf4j
public class MyParameterGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyParameterGatewayFilter: " + new Date());
        String password = exchange.getRequest().getQueryParams().getFirst("password");
        if(!"123456".equals(password)){
            log.info("*****密码不匹配 非法用户,(┬＿┬)");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 给下一个filter
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
