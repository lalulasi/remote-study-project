package com.jun.luo.test;

import com.jun.luo.BeanDefinition;
import com.jun.luo.BeanFactory;
import com.jun.luo.service.UserService;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:36
 **/
public class APITest {
    public static void main(String[] args) {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.execute());
    }

}
