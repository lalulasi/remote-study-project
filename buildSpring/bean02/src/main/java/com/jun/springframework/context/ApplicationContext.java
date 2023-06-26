package com.jun.springframework.context;

import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.factory.ListableBeanFactory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-21 16:39
 **/
/*
也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法。另外 ApplicationContext 本身是 Central 接口，
但目前还不需要添加一些获取ID和父类上下文，所以暂时没有接口方法的定义。
 */
public interface ApplicationContext extends ListableBeanFactory {

}
