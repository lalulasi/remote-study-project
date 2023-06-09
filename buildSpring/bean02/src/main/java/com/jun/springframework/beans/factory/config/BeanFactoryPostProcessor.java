package com.jun.springframework.beans.factory.config;

import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-21 16:33
 **/
/*
这个接口是满足于在所有的 BeanDefinition 加载完成后，
实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制。
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
