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

    List<User> getUserLike(String value);

    List<User> getUserList();

    User getUserById(int id);
    List<User> getUserByIdName(Map<String,Object> map);

    int addUser(User user);

    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
