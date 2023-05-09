package com.lalulasi.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lalulasi.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-27 21:06
 **/
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean deleteById(int id);
    Book getById(int id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
