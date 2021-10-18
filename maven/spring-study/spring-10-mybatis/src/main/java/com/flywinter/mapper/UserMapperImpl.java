package com.flywinter.mapper;

import com.flywinter.entity.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 21:51
 * Description:
 */
public class UserMapperImpl implements UserMapper {

    //我们的所有操作，都使用sqlSession来执行，在原来，现在都使用SqlsessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}