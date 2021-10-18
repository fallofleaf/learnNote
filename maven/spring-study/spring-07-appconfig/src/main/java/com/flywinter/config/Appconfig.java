package com.flywinter.config;

import com.flywinter.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 17:41
 * Description:
 */
@Configuration//也会被Spring容器托管,注册到容器中,
@ComponentScan("com.flywinter.entity")
@Import(Appconfig2.class)
// 因为本质上也是一个Component,和beans.xml一样
public class Appconfig {
    //注册一个bean,就相当于之前写的<bean>标签
    //这个方法的名字 就相当于bean标签中的id属性
    //这个方法的返回值 就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User(); //就是返回要注入bean中的对象
    }
}
