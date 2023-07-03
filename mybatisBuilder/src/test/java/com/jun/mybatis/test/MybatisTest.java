package com.jun.mybatis.test;

import com.jun.mybatis.entity.User;
import com.jun.mybatis.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mybatisBuilder
 * @description:
 * @author: jun.luo
 * @create: 2023-07-03 20:03
 **/
public class MybatisTest {
    InputStream is = null;
    SqlSession sqlSession = null;

    @Before
    public void buildSqlSession() throws IOException {
        //读取MyBatis的核心配置文件
        is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testInsert() {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.insertUser());
    }

    @Test
    public void testUpdate(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
    }

    @Test
    public void testDelete(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
    }

    @Test
    public void findById(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserById());
    }

    @Test
    public void findAll(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (User user : userMapper.findAll()) {
            System.out.println(user);
        }
    }

    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }
}
