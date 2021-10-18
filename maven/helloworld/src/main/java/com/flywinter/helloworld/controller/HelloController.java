package com.flywinter.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/30 14:29
 * Description:
 */
@RestController
public class HelloController {


    @RequestMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
