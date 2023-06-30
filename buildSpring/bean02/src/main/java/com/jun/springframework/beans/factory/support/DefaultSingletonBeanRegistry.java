package com.jun.springframework.beans.factory.support;

import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.factory.DisposableBean;
import com.jun.springframework.beans.factory.ObjectFactory;
import com.jun.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:33
 **/
/*
在用于提供单例对象注册的操作的 DefaultSingletonBeanRegistry 类中，共有三个缓存对象的属性；singletonObjects、earlySingletonObjects、
singletonFactories，如它们的名字一样，用于存放不同类型的对象（单例对象、早期的半成品单例对象、单例工厂对象）。
紧接着在这三个缓存对象下提供了获取、添加和注册不同对象的方法，包括：getSingleton、registerSingleton、addSingletonFactory，
其实后面这两个方法都比较简单，主要是 getSingleton 的操作，它是在一层层处理不同时期的单例对象，直至拿到有效的对象。
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    // 一级缓存，普通对象
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    // 二级缓存，提前暴漏对象，没有完全实例化的对象
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();
    // 三级缓存，存放代理对象
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);
            // 判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (null == singletonObject) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        // 把对象放到一级缓存中
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
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
