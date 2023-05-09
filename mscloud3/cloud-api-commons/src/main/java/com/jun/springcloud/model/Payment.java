package com.jun.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: mscloud3
 * @description:
 * @author: jun.luo
 * @create: 2023-05-08 09:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
    private String cardID;
}
