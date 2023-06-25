package com.jun.springframwork.context.support;

import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.ConfigurableListableBeanFactory;
import com.jun.springframwork.beans.factory.support.DefaultListableBeanFactory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-21 16:37
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
