package com.jun.springframework.beans.factory;

import com.jun.springframework.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-26 16:12
 * 实现此接口，既能感知到所属的 BeanFactory
 **/
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
