package com.flywinter.dao;

import com.flywinter.entity.User;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 0:14
 * Description:
 */
public class UserMapperTest {

    @Test
    public void test(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            System.out.println(userList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
        //��ʽ2  ���Ƽ�
//        List<User> list = sqlSession.selectList("com.flywinter.dao.UserDao.getUserList");
//        for (User user : list) {
//            System.out.println(user);
//        }
    }

    @Test
    public void test2(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

//    ��ɾ����Ҫ�ύ����
    @Test
    public void test3(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.addUser(new User(4, "lis", "123456"));
            if (lis > 0) {
                System.out.println(lis+" ����ɹ�");
            }
//            �ύ����
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

    //    ��ɾ����Ҫ�ύ����
    @Test
    public void test4(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.updateUser(new User(4, "llll", "123456"));
            if (lis > 0) {
                System.out.println(lis+" ���³ɹ�");
            }
//            �ύ����
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

    //    ��ɾ����Ҫ�ύ����
    @Test
    public void test5(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.deleteUser(4);
            if (lis > 0) {
                System.out.println(lis+" ɾ���ɹ�");
            }
//            �ύ����
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test6(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String,Object> map = new HashMap<>();
            map.put("userId",5);
            map.put("userName","hello");
            map.put("password","123");
            int lis = mapper.addUser2(map);
            if (lis > 0) {
                System.out.println(lis+" ����ɹ�");
            }
//            �ύ����
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test7(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String,Object> map = new HashMap<>();
            map.put("userId",5);
            map.put("userName","hello");
            List<User> userByIdName = mapper.getUserByIdName(map);
            System.out.println(userByIdName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test8(){
        //��ʽ1 �Ƽ�
        //��ȡSqlSession����
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //ִ��SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userByIdName = mapper.getUserLike("%��%");
            System.out.println(userByIdName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //�ر�SqlSession
            sqlSession.close();
        }
    }
}
