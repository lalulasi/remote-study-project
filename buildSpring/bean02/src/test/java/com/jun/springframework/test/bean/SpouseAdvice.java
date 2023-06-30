package com.jun.springframework.test.bean;

import com.jun.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 15:39
 **/
public class SpouseAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口(切面)：" + method);
    }
}
