package com.jun.springframework.beans.factory.xml;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.jun.springframework.beans.BeansException;
import com.jun.springframework.beans.PropertyValue;
import com.jun.springframework.beans.PropertyValues;
import com.jun.springframework.beans.factory.config.BeanDefinition;
import com.jun.springframework.beans.factory.config.BeanReference;
import com.jun.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.jun.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.jun.springframework.core.io.Resource;
import com.jun.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:21
 **/
/*
XmlBeanDefinitionReader 类最核心的内容就是对 XML 文件的解析，
把我们本来在代码中的操作放到了通过解析 XML 自动注册的方式。

XmlBeanDefinitionReader 类最核心的内容就是对 XML 文件的解析，把我们本来在代码中的操作放到了通过解析 XML 自动注册的方式。

loadBeanDefinitions 方法，处理资源加载，这里新增加了一个内部方法：doLoadBeanDefinitions，它主要负责解析 xml
在 doLoadBeanDefinitions 方法中，主要是对xml的读取 XmlUtil.readXML(inputStream) 和元素 Element 解析。
在解析的过程中通过循环操作，以此获取 Bean 配置以及配置中的 id、name、class、value、ref 信息。
最终把读取出来的配置信息，创建成 BeanDefinition 以及 PropertyValue，最终把完整的 Bean 定义内容注册到 Bean 容器：
getRegistry().registerBeanDefinition(beanName, beanDefinition)
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try{
            try(InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        }catch (IOException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, BeansException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for(int i = 0; i < childNodes.getLength(); i++){
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) continue;
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //增加对init-method、destroy-method的读取
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");

            // 对象作用域
            String beanScope = bean.getAttribute("scope");

            // 获取Class， 方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id>class
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            // 定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz, new PropertyValues());

            //额外设置到beanDefinition中
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if(StrUtil.isNotEmpty(beanScope)){
                beanDefinition.setScope(beanScope);
            }

            // 读取属性进行填充
            for(int j = 0; j < bean.getChildNodes().getLength(); j++){
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                // 解析标签:property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
