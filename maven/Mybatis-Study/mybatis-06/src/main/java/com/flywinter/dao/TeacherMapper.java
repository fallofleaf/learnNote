package com.flywinter.dao;

import com.flywinter.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 22:43
 * Description:
 */
public interface TeacherMapper {

    //获取老师
    List<Teacher> getTeacher();
    //获取老师及其老师对应的学生
    Teacher getTeacherWthStudent(@Param("tid") int id);
    Teacher getTeacherWthStudent2(@Param("tid") int id);

}
