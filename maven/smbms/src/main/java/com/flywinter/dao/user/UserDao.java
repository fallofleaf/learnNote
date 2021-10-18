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
    //�õ�Ҫ��½���û�
    public User getLoginUser(Connection connection,String userCode) throws SQLException;
    //�޸��û�����
    int updatePwd(Connection connection,int id,String password) throws SQLException;
    //��ѯ�û�����
    int getUserCount(Connection connection,String username,int userRole) throws SQLException;

    //ͨ��������ѯ
    List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    int add(Connection connection, User user) throws Exception;

    int deleteUserById(Connection connection, Integer delId) throws Exception;

    User getUserById(Connection connection, String id) throws Exception;

    int userModify(Connection connection, User user) throws Exception;
}
