package com.lalulasi.library.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-17 21:34
 **/
@Configuration
public class MPConfig {
    
    /** 
    * @Description: 创建一个mybatis plus关于分页的拦截器实现分页功能
    * @Param: [] 
    * @return: com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor 
    * @Author: jun.luo 
    * @Date: 2023/2/17 
    */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
