package com.jun.springframwork.test;


import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.config.BeanDefinition;
import com.jun.springframwork.beans.factory.support.DefaultListableBeanFactory;
import com.jun.springframwork.test.bean.UserService;
import org.junit.Test;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:36
 **/
public class ApiTest {

    @Test
    public void test_BeanFactory() throws BeansException {
        //1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //4. 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
        System.out.println(userService_singleton == userService);
    }
}
