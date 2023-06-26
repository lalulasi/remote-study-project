package com.jun.springframework.utils;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:25
 **/
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        return ClassLoader.getSystemClassLoader();
    }
}
