package com.flywinter.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/23 13:55
 * Description:
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;

    private Date createTime;//属性名和字段名不一致
    private int views;
}
