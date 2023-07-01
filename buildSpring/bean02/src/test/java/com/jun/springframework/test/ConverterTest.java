package com.jun.springframework.test;

import com.jun.springframework.context.support.ClassPathXmlApplicationContext;
import com.jun.springframework.core.convert.support.StringToNumberConverterFactory;
import com.jun.springframework.core.convert.converter.Converter;
import com.jun.springframework.test.bean.Student;
import com.jun.springframework.test.converter.StringToIntegerConverter;
import org.junit.Test;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 17:01
 **/
public class ConverterTest {
    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-converter.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println("测试结果：" + student);
    }

    @Test
    public void test_StringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("1234");
        System.out.println("测试结果：" + num);
    }

    @Test
    public void test_StringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();
        Converter<String, Integer> stringToIntegerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + stringToIntegerConverter.convert("1234"));
        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + stringToLongConverter.convert("1234"));
    }
}
