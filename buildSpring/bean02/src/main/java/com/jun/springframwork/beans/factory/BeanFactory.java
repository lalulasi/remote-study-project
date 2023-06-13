package com.jun.springframwork.beans.factory;

import com.jun.springframwork.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:36
 **/
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
}
