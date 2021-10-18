package com.flywinter.service;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/26 23:52
 * Description:
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新了一个用户");
    }

    @Override
    public void select() {
        System.out.println("查找了一个用户");
    }
}
