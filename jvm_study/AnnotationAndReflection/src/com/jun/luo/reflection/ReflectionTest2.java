package com.jun.luo.reflection;

import java.lang.reflect.Method;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 13:29
 **/
public class ReflectionTest2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> c1 = Class.forName("com.jun.luo.reflection.User");
        c1.getFields();
        c1.getDeclaredFields();

        Method m1 = c1.getDeclaredMethod("getName", null);
        System.out.println(m1);

        User user = (User) c1.newInstance();

    }

}
