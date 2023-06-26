package com.jun.springframework.context;

import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.factory.Aware;

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
