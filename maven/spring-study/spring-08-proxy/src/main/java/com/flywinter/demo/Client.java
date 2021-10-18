package com.flywinter.demo;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 18:46
 * Description:
 */
public class Client {
    public static void main(String[] args) {
//        Host host = new Host();
//        host.rent();
        //房东要租房子
        Host host = new Host();
        //代理,中介要带房东租房子,但是代理角色通常会有些附属操作
        Proxy proxy = new Proxy(host);
        //你不用面对房东,直接找中介租房即可
        proxy.rent();
    }
}
