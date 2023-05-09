package com.jun.luo.reflection;

import java.lang.reflect.Field;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 11:10
 **/
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.jun.luo.reflection.User");
        Class<?> c2 = c1.getSuperclass();
        System.out.println(c2);

        int[] a = new int[10];
        System.out.println(String[].class);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);

        ClassLoader classLoader = Class.forName("com.jun.luo.reflection.ReflectionTest").getClassLoader();
        System.out.println(classLoader);

        ClassLoader objClassLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(objClassLoader);
    }
}
