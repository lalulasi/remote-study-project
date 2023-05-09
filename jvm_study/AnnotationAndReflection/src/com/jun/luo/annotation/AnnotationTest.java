package com.jun.luo.annotation;

import java.lang.annotation.*;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 09:52
 **/
@MyAnnotation
public class AnnotationTest {

    @MyAnnotation
    public void test(){

    }
}

// 表示我们的注解可以用在哪些地方
@Target(value= {ElementType.METHOD,ElementType.TYPE})
// 表示我们的注解在什么地方还有效, runtime > class > source
@Retention(RetentionPolicy.RUNTIME)
// 表示是否将注解是否生成在Javadoc中
@Documented
// 子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
