package com.jun.springframework.aop;

import com.jun.springframework.utils.ClassUtils;

import java.util.Arrays;

/**
 * @program: buildSpring
 * @description: 被代理的目标对象
 * @author: jun.luo
 * @create: 2023-06-27 16:47
 **/
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * Return the type of targets returned by this {@link TargetSource}.
     * <p>Can return <code>null</code>, although certain usages of a
     * <code>TargetSource</code> might just work with a predetermined
     * target class.
     * @return the type of targets returned by this {@link TargetSource}
     */
    public Class<?>[] getTargetClass(){
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        System.out.println(Arrays.toString(clazz.getInterfaces()));
        return clazz.getInterfaces();
    }

    /**
     * Return a target instance. Invoked immediately before the
     * AOP framework calls the "target" of an AOP method invocation.
     * @return the target object, which contains the joinpoint
     * @throws Exception if the target object can't be resolved
     */
    public Object getTarget(){
        return this.target;
    }
}
