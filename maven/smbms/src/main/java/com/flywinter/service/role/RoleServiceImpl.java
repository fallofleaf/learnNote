package com.flywinter.service.role;

import com.flywinter.dao.BaseDao;
import com.flywinter.dao.role.RoleDao;
import com.flywinter.dao.role.RoleDaoImpl;
import com.flywinter.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/21 0:28
 * Description:
 */
public class RoleServiceImpl implements RoleService{
    //“˝»ÎDao
    private RoleDao roleDao;
    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleList(){
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
}
