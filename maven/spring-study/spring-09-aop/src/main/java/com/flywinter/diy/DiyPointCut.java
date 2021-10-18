package com.flywinter.diy;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 1:00
 * Description:
 */
public class DiyPointCut {
    public void before() {
        System.out.println("方法执行前");
    }

    public void after() {
        System.out.println("方法执行后");
    }

}
