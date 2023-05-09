package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-08 11:17
 **/
@RestController
@RequestMapping("/books")
public class BookController {

    //读取yml数据
    @Value("${country}")
    private String country;

    @GetMapping
    @RequestMapping("/book")
    public String listBooks(){
        return "start spring boot ==> " + country;
    }
}
