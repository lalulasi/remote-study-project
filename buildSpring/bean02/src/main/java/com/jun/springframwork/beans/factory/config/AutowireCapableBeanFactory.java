package com.jun.springframwork.beans.factory.config;

import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.BeanFactory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:19
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
