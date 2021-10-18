package com.flywinter.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 17:09
 * Description:
 */
//等价于    <bean id="user" class="com.flywinter.entity.User"/>
//@Component 组件
@Component
//@Scope("prototype")
public class User {
    //相当于<property name="name" value="Alex"/>
//    @Value("Alex")
    public String name = "Alex";

    @Value("Alex")
    public void setName(String name) {
        this.name = name;
    }
}
