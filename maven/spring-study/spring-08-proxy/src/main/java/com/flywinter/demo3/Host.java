package com.flywinter.demo3;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 18:44
 * Description:
 */
//房东
public class Host implements Rent {
    @Override
    public void rent(){
        System.out.println("房东要出租房子");
    }
}
