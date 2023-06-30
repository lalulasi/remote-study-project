package com.jun.springframework.test;

import com.jun.springframework.context.support.ClassPathXmlApplicationContext;
import com.jun.springframework.test.bean.Husband;
import com.jun.springframework.test.bean.Wife;
import org.junit.Test;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 15:45
 **/
public class CircularTest {

    @Test
    public void test_circular(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
