package com.jun.springframwork.context.support;

import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.config.BeanPostProcessor;
import com.jun.springframwork.context.ApplicationContext;
import com.jun.springframwork.context.ApplicationContextAware;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-26 16:18
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
