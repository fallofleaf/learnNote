package com.flywinter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/29 23:10
 * Description:
 */
@Controller
//@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello Spring");
        return "hello";//会被视图解析器处理
    }

}
