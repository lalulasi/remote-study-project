package com.jun.springframework.test;

import com.jun.springframework.context.support.ClassPathXmlApplicationContext;
import com.jun.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-27 16:37
 **/
public class EventTest {

    @Test
    public void test_event(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 123L, "this is a message"));
        applicationContext.registerShutdownHook();
    }
}
