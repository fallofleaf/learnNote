package com.flywinter;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 23:52
 * Description:
 */
public class User {
    private String name;

    public User() {
        System.out.println("User的无参构造");
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }
}
