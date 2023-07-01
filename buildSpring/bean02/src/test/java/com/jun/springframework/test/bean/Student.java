package com.jun.springframework.test.bean;

import java.util.Date;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-30 16:52
 **/
public class Student {
    private String id;
    // 学生注册时间
    private Date registryTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(Date registryTime) {
        this.registryTime = registryTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", registryTime=" + registryTime +
                '}';
    }
}
