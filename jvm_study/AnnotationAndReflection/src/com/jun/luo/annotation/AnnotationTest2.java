package com.jun.luo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 10:44
 **/
public class AnnotationTest2 {

    @MyAnnotation2(name = "av", age=12)
    public void test(){

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> c1 = ClassLoader.getSystemClassLoader().loadClass("com.jun.luo.annotation.AnnotationTest2");
        Method m1 = c1.getDeclaredMethod("test");
        MyAnnotation2 annotation2 = m1.getAnnotation(MyAnnotation2.class);
        System.out.println(annotation2.name());
        System.out.println(annotation2.age());
        System.out.println(annotation2.id());
    }
}

@Target(value={ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数， 参数类型 + 参数名();
    String name() default "";
    int age() default 20;
    int id() default -1;
}
