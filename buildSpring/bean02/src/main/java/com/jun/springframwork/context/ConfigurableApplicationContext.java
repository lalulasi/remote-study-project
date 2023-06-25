package com.jun.springframwork.context;

import com.jun.springframwork.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-21 16:39
 **/
/*
需要在上下文的实现中完成刷新容器的操作过程。
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
