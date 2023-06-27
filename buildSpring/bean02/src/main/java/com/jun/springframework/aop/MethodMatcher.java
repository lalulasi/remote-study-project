package com.jun.springframework.aop;

import java.lang.reflect.Method;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-27 16:46
 **/
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
