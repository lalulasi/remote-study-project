package com.jun.luo;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-09 16:35
 **/
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
