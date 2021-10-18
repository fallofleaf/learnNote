package com.flywinter.dao;

import com.flywinter.entity.Student;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 22:43
 * Description:
 */
public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师信息
    List<Student> getStudent();
    List<Student> getStudent2();
}
