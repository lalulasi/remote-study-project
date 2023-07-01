package com.jun.springframework.core.convert.converter;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 16:02
 **/
public interface Converter<S, T> {
    /** Convert the source object of type {@code S} to target type {@code T}. */
    T convert(S source);
}
