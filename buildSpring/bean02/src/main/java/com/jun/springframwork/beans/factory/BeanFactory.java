package com.jun.springframwork.beans.factory;

import com.jun.springframwork.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:36
 **/
public interface BeanFactory {
    // Object getBean(String beanName) throws BeansException;
    // 增加可带参数构造方法的接口 这样就可以方便的传递入参给构造函数实例化了。
    Object getBean(String beanName, Object... args) throws BeansException;
}
