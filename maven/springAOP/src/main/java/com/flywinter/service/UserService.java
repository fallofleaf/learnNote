package com.flywinter.service;

import com.flywinter.entity.User;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 17:25
 * Description:
 */
public interface UserService {
    void add(String name);
    void delete(User user);

    User select(User user);

    void update();
}
