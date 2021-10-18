package com.flywinter.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 22:41
 * Description:
 */
@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师
    private Teacher teacher;
}
