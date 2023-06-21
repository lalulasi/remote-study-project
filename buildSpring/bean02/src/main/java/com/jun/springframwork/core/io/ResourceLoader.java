package com.jun.springframwork.core.io;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:24
 **/
/*
按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，
外部用户只需要传递资源地址即可，简化使用。

 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
