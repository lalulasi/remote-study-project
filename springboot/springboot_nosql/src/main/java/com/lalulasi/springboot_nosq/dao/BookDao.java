package com.lalulasi.springboot_nosq.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lalulasi.springboot_nosq.model.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-17 22:01
 **/
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
