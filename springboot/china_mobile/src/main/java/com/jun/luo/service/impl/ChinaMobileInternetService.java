package com.jun.luo.service.impl;

import com.jun.luo.service.InternetService;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-04-20 11:03
 **/
public class ChinaMobileInternetService implements InternetService {
    @Override
    public void connectToInternet() {
        System.out.println("connect to Internet with china mobile");
    }
}
