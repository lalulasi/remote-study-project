package com.lalulasi.library.resource.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-01 20:45
 **/
// spring的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常
    @ExceptionHandler
    public R doException(Exception e){
        e.printStackTrace();
        return new R(false, null, e.getMessage());
    }
}
