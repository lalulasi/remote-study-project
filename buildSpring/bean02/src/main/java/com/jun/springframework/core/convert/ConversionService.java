package com.jun.springframework.core.convert;

import com.sun.istack.internal.Nullable;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 16:14
 * 类型转换抽象接口
 **/
public interface ConversionService {
    /** Return {@code true} if objects of {@code sourceType} can be converted to the {@code targetType}. */
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    /** Convert the given {@code source} to the specified {@code targetType}. */
    <T> T convert(Object source, Class<T> targetType);
}
