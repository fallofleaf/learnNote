package com.flywinter.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//标注这个类是一个SpringBoot应用
@SpringBootApplication
public class HelloworldApplication {

//    将SpringBoot应用启动
    //SpringApplication类
    //run方法
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
