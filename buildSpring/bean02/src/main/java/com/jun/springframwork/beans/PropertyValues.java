package com.jun.springframwork.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-19 16:57
 **/
// 属性的集合
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    // 添加属性
    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    // 转换成数组
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    // 获取属性
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : this.propertyValueList) {
            System.out.println(pv.getName());
            if(pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}
