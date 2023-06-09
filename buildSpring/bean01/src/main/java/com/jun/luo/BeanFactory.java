package com.jun.luo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:36
 **/
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
    }
}
