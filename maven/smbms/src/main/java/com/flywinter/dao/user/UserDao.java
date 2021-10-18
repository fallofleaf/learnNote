package com.flywinter.dao.user;

import com.flywinter.entity.Role;
import com.flywinter.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 20:55
 * Description:
 */
public interface UserDao {
    //得到要登陆的用户
    public User getLoginUser(Connection connection,String userCode) throws SQLException;
    //修改用户密码
    int updatePwd(Connection connection,int id,String password) throws SQLException;
    //查询用户总数
    int getUserCount(Connection connection,String username,int userRole) throws SQLException;

    //通过条件查询
    List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    int add(Connection connection, User user) throws Exception;

    int deleteUserById(Connection connection, Integer delId) throws Exception;

    User getUserById(Connection connection, String id) throws Exception;

    int userModify(Connection connection, User user) throws Exception;
}
