package com.jun.springframework.beans.factory;

import com.jun.springframework.beans.BeansException;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 15:16
 **/
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
