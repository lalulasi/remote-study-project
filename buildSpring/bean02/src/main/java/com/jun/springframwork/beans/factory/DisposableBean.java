package com.jun.springframwork.beans.factory;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-25 16:34
 **/
// 销毁之后调用的接口
public interface DisposableBean {
    void destroy() throws Exception;
}
