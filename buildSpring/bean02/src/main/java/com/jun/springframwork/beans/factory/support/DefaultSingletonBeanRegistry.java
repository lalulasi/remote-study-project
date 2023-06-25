package com.jun.springframwork.beans.factory.support;

import com.jun.springframwork.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:33
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {

    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }
}
