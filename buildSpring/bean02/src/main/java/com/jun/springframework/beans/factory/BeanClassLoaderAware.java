package com.jun.springframwork.beans.factory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-26 16:12
 * 实现此接口，既能感知到所属的 ClassLoader
 **/
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
