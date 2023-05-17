package com.jun.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-17 10:11
 **/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
