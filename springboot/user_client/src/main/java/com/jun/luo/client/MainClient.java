package com.jun.luo.client;

import com.jun.luo.service.InternetService;

import java.util.ServiceLoader;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-04-20 11:14
 **/
public class MainClient {
    public static void main(String[] args) {
        ServiceLoader<InternetService> services = ServiceLoader.load(InternetService.class);
        for (InternetService service : services) {
            service.connectToInternet();
        }
    }
}
