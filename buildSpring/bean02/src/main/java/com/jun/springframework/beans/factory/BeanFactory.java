package com.jun.springframework.beans.factory;

import com.jun.springframework.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:36
 **/
public interface BeanFactory {
    // Object getBean(String beanName) throws BeansException;
    // 增加可带参数构造方法的接口 这样就可以方便的传递入参给构造函数实例化了。
    /**
     * 返回 Bean 的实例对象
     * @param name 要检索的bean的名称
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 返回含构造函数的 Bean 实例对象
     * @param name 要检索的bean的名称
     * @param args 构造函数入参
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 返回指定泛型的对象
     * @param name  要检索的bean的名称
     * @param requiredType 类型
     * @param <T>          泛型
     * @return             实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     * 返回指定泛型的对象
     * @param requiredType 类型
     * @param <T>          泛型
     * @return             实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;
}
