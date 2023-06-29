package com.jun.springframework.utils;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-29 15:51
 **/
//定义解析字符串接口
public interface StringValueResolver {
    String resolveStringValue(String strVal);
}
