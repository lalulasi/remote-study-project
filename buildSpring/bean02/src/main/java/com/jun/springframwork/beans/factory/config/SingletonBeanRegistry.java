package com.jun.springframwork.beans.factory.config;

import com.jun.springframwork.beans.factory.support.BeanDefinitionRegistry;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:30
 **/
public interface SingletonBeanRegistry {
   Object getSingleton(String beanName);
}
