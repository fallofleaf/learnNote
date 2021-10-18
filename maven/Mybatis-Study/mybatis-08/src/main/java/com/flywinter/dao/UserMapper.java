package com.flywinter.dao;

import com.flywinter.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 17:14
 * Description:
 */
public interface UserMapper {
    //根据Id查询用户
    User queryUserById(@Param("id") int id);
}
