package com.lalulasi.library.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lalulasi.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-13 21:17
 **/
@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave(){
        Book book = new Book();
        String id = UUID.randomUUID().toString().replaceAll("-", "") + new Date().getTime();
        book.setId(id);
        book.setCategory("CS");
        book.setName("C++20高级编程");
        book.setDescription("C++20高级编程主要讲解C++库、框架发中的高级编程技术，以及最新的C++20标准特性。");
        bookDao.insert(book);
    }


    @Test
    void testGetPage(){
        IPage<Book> page = new Page<>(1, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void getAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("category", "CS");
        bookDao.selectList(qw);
    }
}
