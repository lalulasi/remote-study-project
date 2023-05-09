package com.jun.luo.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 14:13
 **/
// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StuField {
    String columnName();
    String type();
    int length();
}
