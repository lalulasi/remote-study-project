package com.jun.luo.service.impl;

import com.jun.luo.service.InternetService;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-04-20 11:04
 **/
public class ErrorInternetService implements InternetService {
    @Override
    public void connectToInternet() {
        System.out.println("connect to Internet with errors");
    }
}
