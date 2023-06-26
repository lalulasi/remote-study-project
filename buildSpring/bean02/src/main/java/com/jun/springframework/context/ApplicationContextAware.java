package com.jun.springframwork.context;

import com.jun.springframwork.beans.BeansException;
import com.jun.springframwork.beans.factory.Aware;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-26 16:18
 * 实现此接口，既能感知到所属的 ApplicationContext
 **/
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
