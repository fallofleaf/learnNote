package com.flywinter.service;

import com.flywinter.dao.UserDao;
import com.flywinter.dao.UserDaoImpl;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 22:24
 * Description:
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;


    //利用Set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser(){
        userDao.getUser();
    }
}
