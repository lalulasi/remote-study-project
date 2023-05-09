package com.lalulasi.springboot_nosq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-13 20:51
 **/


@Data //lombok
@AllArgsConstructor // 全参数构造方法
@NoArgsConstructor // 无参构造方法
public class Book {
    // 使用uuid
    private String id;
    private String category;
    private String name;
    private String description;


    public Book(String category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }
}
