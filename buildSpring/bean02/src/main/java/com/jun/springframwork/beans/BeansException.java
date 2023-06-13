package com.jun.springframwork.beans;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-12 16:34
 **/
public class BeansException extends Exception{
    public BeansException(String message){
        super(message);
    }

    public BeansException(String message, Throwable cause){
        super(message, cause);
    }
}
