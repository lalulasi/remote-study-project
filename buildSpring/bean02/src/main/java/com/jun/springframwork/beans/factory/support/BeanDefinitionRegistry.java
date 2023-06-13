package com.jun.springframwork.beans.factory.support;

import com.jun.springframwork.beans.factory.config.BeanDefinition;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:33
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
