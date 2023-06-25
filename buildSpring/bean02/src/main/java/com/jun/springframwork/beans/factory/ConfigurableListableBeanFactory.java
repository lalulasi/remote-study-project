package com.jun.springframwork.beans.factory;

import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.config.AutowireCapableBeanFactory;
import com.jun.springframwork.beans.factory.config.BeanDefinition;
import com.jun.springframwork.beans.factory.config.ConfigurableBeanFactory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:22
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
