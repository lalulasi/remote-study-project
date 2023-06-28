package com.jun.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.jun.springframework.beans.factory.config.BeanDefinition;
import com.jun.springframework.stereotype.Component;
import com.jun.springframework.utils.ClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-28 16:26
 **/
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
