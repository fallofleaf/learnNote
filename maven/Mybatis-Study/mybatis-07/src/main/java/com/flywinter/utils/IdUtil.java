package com.flywinter.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/23 13:59
 * Description:
 */
public class IdUtil {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void test(){
        System.out.println(getId());
    }
}
