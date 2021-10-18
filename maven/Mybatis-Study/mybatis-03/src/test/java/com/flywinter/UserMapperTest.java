package com.flywinter;

import com.flywinter.dao.UserMapper;
import com.flywinter.entity.User;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 0:14
 * Description:
 */
public class UserMapperTest {

    final Logger logger = Logger.getLogger(UserMapperTest.class);


    @Test
    public void test() {
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        logger.info("进入test方法中");
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public void test1() {

        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public void test3() {
        //方式1 推荐
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<>();
            map.put("startIndex", 1);
            map.put("pageSize", 2);
            List<User> userList = mapper.getUserByLimit(map);
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test4() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.flywinter.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }

}
