package com.jun.springframework.test;

import com.jun.springframework.context.support.ClassPathXmlApplicationContext;
import com.jun.springframework.test.bean.IUserService;
import org.junit.Test;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-28 16:45
 **/
public class AnnotationTest {
    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService studentService = applicationContext.getBean("studentService", IUserService.class);
        System.out.println("测试结果：" + studentService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService studentService = applicationContext.getBean("studentService", IUserService.class);
        System.out.println("测试结果：" + studentService.queryUserInfo());
    }

    @Test
    public void test_anno_property(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_proxyObj_annotation_property(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
