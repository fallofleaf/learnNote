package com.flywinter;

import com.flywinter.dao.TeacherMapper;
import com.flywinter.entity.Teacher;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/23 12:48
 * Description:
 */
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher();
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherWthStudent = mapper.getTeacherWthStudent(1);
        System.out.println(teacherWthStudent);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherWthStudent = mapper.getTeacherWthStudent2(1);
        System.out.println(teacherWthStudent);
        sqlSession.close();
    }
}
