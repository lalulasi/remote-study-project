package com.jun.springframework.test.converter;

import com.jun.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 16:54
 **/
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    private final DateTimeFormatter DATE_TIME_FORMATTER;

    public StringToLocalDateConverter(String pattern) {
        DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, DATE_TIME_FORMATTER);
    }
}
