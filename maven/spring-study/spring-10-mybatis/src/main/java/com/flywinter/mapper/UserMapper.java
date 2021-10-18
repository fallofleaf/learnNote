package com.flywinter.mapper;

import com.flywinter.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 21:31
 * Description:
 */
public interface UserMapper {
    public List<User> selectUser();
}