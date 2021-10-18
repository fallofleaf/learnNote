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
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            System.out.println(userList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
        //方式2  不推荐
//        List<User> list = sqlSession.selectList("com.flywinter.dao.UserDao.getUserList");
//        for (User user : list) {
//            System.out.println(user);
//        }
    }

    @Test
    public void test2(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

//    增删改需要提交事务
    @Test
    public void test3(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.addUser(new User(4, "lis", "123456"));
            if (lis > 0) {
                System.out.println(lis+" 插入成功");
            }
//            提交事务
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    //    增删改需要提交事务
    @Test
    public void test4(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.updateUser(new User(4, "llll", "123456"));
            if (lis > 0) {
                System.out.println(lis+" 更新成功");
            }
//            提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    //    增删改需要提交事务
    @Test
    public void test5(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int lis = mapper.deleteUser(4);
            if (lis > 0) {
                System.out.println(lis+" 删除成功");
            }
//            提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test6(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String,Object> map = new HashMap<>();
            map.put("userId",5);
            map.put("userName","hello");
            map.put("password","123");
            int lis = mapper.addUser2(map);
            if (lis > 0) {
                System.out.println(lis+" 插入成功");
            }
//            提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test7(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String,Object> map = new HashMap<>();
            map.put("userId",5);
            map.put("userName","hello");
            List<User> userByIdName = mapper.getUserByIdName(map);
            System.out.println(userByIdName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test8(){
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userByIdName = mapper.getUserLike("%李%");
            System.out.println(userByIdName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
