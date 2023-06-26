package com.jun.springframework.context.support;
import com.jun.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.jun.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-21 16:37
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
