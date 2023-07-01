package com.jun.springframework.test.converter;

import com.jun.springframework.core.convert.converter.Converter;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 17:02
 **/
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.parseInt(source);
    }
}
