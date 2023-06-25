package com.jun.springframwork.test;

import cn.hutool.core.io.IoUtil;
import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.context.support.ClassPathXmlApplicationContext;
import com.jun.springframwork.core.io.DefaultResourceLoader;
import com.jun.springframwork.core.io.Resource;
import com.jun.springframwork.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 17:17
 **/
public class XmlTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();
        // 3. 获取Bean对象调用方法
        UserService userService = context.getBean("userService", UserService.class);
        userService.showUser();
        //System.out.println("测试结果：" + result);
    }


}
