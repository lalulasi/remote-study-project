package com.lalulasi.springboot_nosq.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-16 22:00
 **/
@Data //lombok
@AllArgsConstructor // 全参数构造方法
@NoArgsConstructor // 无参构造方法
public class User {
    private String id;
    private int age;
    private String name;


}
