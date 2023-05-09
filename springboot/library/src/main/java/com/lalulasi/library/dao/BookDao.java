package com.lalulasi.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lalulasi.library.model.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-13 21:12
 **/
@Mapper
public interface BookDao extends BaseMapper<Book> { // my_batis plus继承

}
