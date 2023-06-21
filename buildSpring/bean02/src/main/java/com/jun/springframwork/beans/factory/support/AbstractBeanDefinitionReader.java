package com.jun.springframwork.beans.factory.support;

import com.jun.springframwork.core.io.DefaultResourceLoader;
import com.jun.springframwork.core.io.ResourceLoader;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:20
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
