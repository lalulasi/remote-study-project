package com.lalulasi.library.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lalulasi.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-27 21:04
 **/
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(2));
    }

    @Test
    void testGetPage(){
        System.out.println(bookService.page(new Page<>(2, 5)).getRecords());
    }

    @Test
    void testGetPage2(){
        bookService.getBookPage(1, 10, new Book());
    }
}
