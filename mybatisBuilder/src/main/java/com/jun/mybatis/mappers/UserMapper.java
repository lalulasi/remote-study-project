package com.jun.mybatis.mappers;

import com.jun.mybatis.entity.User;

import java.util.List;

/**
 * @program: mybatisBuilder
 * @description:
 * @author: jun.luo
 * @create: 2023-07-03 20:00
 **/
public interface UserMapper {
    /**
     * insert user
     * @return
     */
    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> findAll();
}
