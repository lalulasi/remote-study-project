package com.jun.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.PropertyValues;
import com.jun.springframework.beans.factory.BeanFactory;
import com.jun.springframework.beans.factory.BeanFactoryAware;
import com.jun.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.jun.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.jun.springframework.utils.ClassUtils;

import java.lang.reflect.Field;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-29 16:10
 **/
/*
用于在 Bean 对象实例化完成后，设置属性操作前的处理属性信息的类和操作方法。
只有实现了 BeanPostProcessor 接口才有机会在 Bean 的生命周期中处理初始化信息
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) {
        return InstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }
}
