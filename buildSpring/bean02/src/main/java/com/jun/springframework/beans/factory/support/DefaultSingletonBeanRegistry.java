package com.jun.springframework.beans.factory.support;

import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.factory.DisposableBean;
import com.jun.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:33
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean){
        disposableBeans.put(beanName, bean);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }

    public void destroySingletons(){
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for(int i = disposableBeanNames.length - 1; i >= 0; i--){
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
