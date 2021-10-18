package com.flywinter.demo2;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 19:36
 * Description:
 */
public class UserServiceProxy implements UserService{

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.add();
    }

    @Override
    public void update() {
        log("update");
        userService.add();
    }

    @Override
    public void query() {
        log("query");
        userService.add();
    }

    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
