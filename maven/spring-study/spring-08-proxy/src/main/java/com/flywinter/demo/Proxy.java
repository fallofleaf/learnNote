package com.flywinter.demo;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 18:48
 * Description:
 */
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        fee();
    }

    public void  seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void fee(){
        System.out.println("收中介费");
    }
}
