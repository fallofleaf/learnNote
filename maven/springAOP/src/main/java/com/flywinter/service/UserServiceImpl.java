package com.flywinter.service;

import com.flywinter.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 17:26
 * Description:
 */
@Component
public class UserServiceImpl implements UserService{
    @Override
    public void add(String name) {
        System.out.println(name);
    }

    @Override
    public void delete(User user) {
        System.out.println("delete"+user);
    }

    @Override
    public User select(User user) {
        System.out.println("select");
        return user;
    }

    @Override
    public void update() {
        System.out.println("udpdate");
    }
}
