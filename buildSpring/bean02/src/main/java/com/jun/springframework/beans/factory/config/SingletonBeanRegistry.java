package com.jun.springframework.beans.factory.config;

import com.jun.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:30
 **/
public interface SingletonBeanRegistry {
   /**
    * 返回在给定名称下注册的（原始）单例对象。
    * @param beanName 要查找的bean的名称
    * @return 返回注册的单例对象
    */
   Object getSingleton(String beanName);

   /**
    * 注册单利对象
    * @param beanName          Bean 对象名称
    * @param singletonObject   Bean 对象
    */
   void registerSingleton(String beanName, Object singletonObject);
}
