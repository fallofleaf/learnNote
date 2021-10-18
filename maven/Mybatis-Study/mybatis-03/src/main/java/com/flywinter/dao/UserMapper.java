package com.flywinter.dao;

import com.flywinter.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 0:05
 * Description:
 */
public interface UserMapper {


    List<User> getUserList();
    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页2
    List<User> getUserByRowBounds();

}
