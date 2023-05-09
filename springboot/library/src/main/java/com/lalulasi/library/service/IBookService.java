package com.lalulasi.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lalulasi.library.model.Book;


/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-27 21:31
 **/
public interface IBookService extends IService<Book> {
    IPage<Book> getBookPage(int currentPage, int pageSize, Book book);
}
