package com.jun.springframwork.beans;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-19 16:57
 **/
// PropertyValue(属性值) 需要注入的属性
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
