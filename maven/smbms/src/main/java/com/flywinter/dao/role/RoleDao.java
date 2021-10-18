package com.flywinter.dao.role;

import com.flywinter.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/21 0:26
 * Description:
 */
public interface RoleDao {
    //获取角色列表
    List<Role> getRoleList(Connection connection) throws SQLException;
}
