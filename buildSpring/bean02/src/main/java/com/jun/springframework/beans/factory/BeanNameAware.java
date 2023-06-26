package com.jun.springframwork.beans.factory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-26 16:12
 * 实现此接口，既能感知到所属的 BeanName
 **/
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
