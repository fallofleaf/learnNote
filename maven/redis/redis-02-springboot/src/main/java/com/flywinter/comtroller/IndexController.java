package com.flywinter.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/8/9 15:13
 * Description:
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
}
