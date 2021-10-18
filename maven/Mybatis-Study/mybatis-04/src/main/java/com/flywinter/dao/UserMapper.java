package com.flywinter.dao;

import com.flywinter.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 0:05
 * Description:
 */
public interface UserMapper {
    @Select("select * from mybatis.user")
    List<User> getUserList();

    //注解存在多个参数，必须每个参数加@Param注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);
}
