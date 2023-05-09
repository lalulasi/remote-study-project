package com.lalulasi.library.resource.utils;

import lombok.Data;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-28 12:27
 **/
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String errMsg;

    public R(){}

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, Object data, String errMsg) {
        this.flag = flag;
        this.data = data;
        this.errMsg = errMsg;
    }
}
