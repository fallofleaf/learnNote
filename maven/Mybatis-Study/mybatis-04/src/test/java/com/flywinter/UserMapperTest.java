package com.flywinter;

import com.flywinter.dao.UserMapper;
import com.flywinter.entity.User;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 15:31
 * Description:
 */
public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //底层主要使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
        sqlSession.close();
    }
}
