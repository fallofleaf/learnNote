package com.flywinter;

import com.flywinter.dao.UserMapper;
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

}
