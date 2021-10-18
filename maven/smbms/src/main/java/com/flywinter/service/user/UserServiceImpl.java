package com.flywinter.service.user;

import com.flywinter.dao.BaseDao;
import com.flywinter.dao.user.UserDao;
import com.flywinter.dao.user.UserDaoImpl;
import com.flywinter.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 21:16
 * Description:
 */
public class UserServiceImpl implements UserService{
    //业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        connection = BaseDao.getConnection();
        //通过业务层调用对应的具体数据库操作
        try {
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            if (userDao.updatePwd(connection,id,password) > 0) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    //查询数据记录
    @Override
    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            userDao.getUserCount(connection,username,userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return count;
    }


    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize){
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---> " + queryUserName);
        System.out.println("queryUserRole ---> " + queryUserRole);
        System.out.println("currentPageNo ---> " + currentPageNo);
        System.out.println("pageSize ---> " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection,queryUserName,queryUserRole,currentPageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }

    /**
     * @param user
     * @description: 添加用户
     * @Param: [user]
     * @Return: boolean
     */
    @Override
    public boolean add(User user) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            //关闭自动提交，默认开启jdbc事物
            connection.setAutoCommit(false);
            int addRows = userDao.add(connection, user);
            connection.commit();
            if (addRows > 0) {
                flag = true;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection,null, null );
        }
        return flag;
    }

    /**
     * @param userCode
     * @description: 根据UserCode查询用户
     * @date 20/12/7 18:03
     * @Param: [userCode]
     * @Return: com.threepure.pojo.User
     */
    @Override
    public User selectUserCodeExist(String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null, null);
        }
        return user;
    }

    /**
     * @param delId
     * @description: 根据ID删除用户
     * @Param: [delId]
     * @Return: boolean
     */
    @Override
    public boolean deleteUserById(Integer delId) throws Exception {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            int i = userDao.deleteUserById(connection, delId);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null, null);
        }
        return flag;
    }

    /**
     * @param id
     * @description: 根据id查找User
     * @Param: [id]
     */
    @Override
    public User getUserById(String id) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUserById(connection, id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null, null);
        }
        return user;
    }

    /**
     * @param user
     * @description: 修改用户信息
     * @Param: [user]
     * @Return: boolean
     */
    @Override
    public boolean userModify(User user) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            //关闭自动提交，默认开启jdbc事物
            connection.setAutoCommit(false);
            int updateRows = userDao.userModify(connection, user);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection,null, null);
        }
        return flag;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("test", "123456");
        System.out.println(admin.getUserPassword());
    }
}
