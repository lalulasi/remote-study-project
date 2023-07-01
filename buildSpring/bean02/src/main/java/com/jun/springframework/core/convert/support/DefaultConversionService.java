package com.jun.springframework.core.convert.support;

import com.jun.springframework.core.convert.converter.ConverterRegistry;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 16:11
 **/
public class DefaultConversionService extends GenericConversionService {
    public DefaultConversionService(){
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
