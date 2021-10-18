package com.flywinter.dao;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 22:24
 * Description:
 */
public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser(){
        System.out.println("默认获取用户的数据MySql实现");
    }
}
