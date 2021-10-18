package com.flywinter.dao.user;

import com.flywinter.dao.BaseDao;
import com.flywinter.entity.Role;
import com.flywinter.entity.User;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 20:56
 * Description:
 */
public class UserDaoImpl implements UserDao {
    /**
     * @description: �ж��û��Ƿ����
     * @Param: [connection, userCode]
     */
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    /**
     * �޸��û�����
     * @param connection
     * @param id
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        int execute = 0;
        if (connection !=null) {
            String sql = "update smbms_user set userPassword = ? where id =?";
            Object[] params = {password,id};
            execute = BaseDao.execute(connection, preparedStatement, sql, params);
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return execute;
    }
    //�����û������ɫ��ѯ�û�����
    @Override
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection !=null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<>();

            if (!StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ?");
                list.add("%"+username+"%");
            }
            if (userRole > 0) {
                sql.append(" and u.userName like ?");
                list.add(userRole);
            }
            //��ô��listת��Ϊ����
            Object[] params = list.toArray();
            System.out.println("userDao->getUserCount"+sql.toString());
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql.toString(), params);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return count;
    }

//    /**
//     * @description: �޸��û�����ľ���ʵ�ַ���
//     * @date 20/12/2 8:21
//     * @Param:[connection, id, password]
//     * @Return:int
//     */
//    @Override
//    public int updatePwd(Connection connection, int id, String password) throws SQLException {
//
//        PreparedStatement pstm = null;
//        int execute = 0;
//
//        if (connection != null) {
//            String sql = "update smbms_user set userPassword = ? where id = ?";
//            Object[] params = {password, id};
//            execute = BaseDao.execute(connection, pstm, sql, params);
//            BaseDao.closeResource(null, pstm, null);
//        }
//        return execute;
//    }
//
//    /**
//     * @description: �����û������߽�ɫ��ѯ�û�������������Ŀ��������SQL��
//     * @Return:int
//     */
//    @Override
//    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
//        PreparedStatement pstm = null;
//        ResultSet resultSet = null;
//        int count = 0;
//        if (connection != null) {
//            StringBuffer sql = new StringBuffer();
//            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole=r.id");
//            //����һ���б����ڴ�����ǵĲ���
//            ArrayList<Object> list = new ArrayList<Object>();
//
//            if (!StringUtils.isNullOrEmpty(userName)) {
//                sql.append(" and u.userName like ?");
//                list.add("%" + userName + "%");
//            }
//            if (userRole > 0) {
//                sql.append(" and u.userRole = ?");
//                list.add(userRole);
//            }
//
//            //��listת��������
//            Object[] params = list.toArray();
//
//            //System.out.println("UserDaoImpl--->getUserCount():" + sql.toString());
//
//            resultSet = BaseDao.execute(connection, pstm, resultSet, sql.toString(), params);
//            if (resultSet.next()) {
//                count = resultSet.getInt("count");
//            }
//            BaseDao.closeResource(resultSet, pstm, null);
//        }
//        return count;
//    }
//
    /**
     * @description: ��ȡ�û��б�Ľӿ�
     */
    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id ");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                sql.append(" and u.userRole =?");
                list.add(userRole);
            }
            //�����ݿ��У���ҳʹ�� limit startIndex��pagesize������
            //��ǰҳ����ǰҳ-1��*ҳ���С
            //0��  5      1    0       01234
            //5��  5      2    5       26789
            //10�� 5      3    10
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            //System.out.println("sql---->" + sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            while (rs.next()) {
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return userList;
    }





    /**
     * @param connection
     * @param user
     * @description: ����û�
     */
    @Override
    public int add(Connection connection, User user) throws Exception {
        PreparedStatement pstm = null;
        int addRows = 0;
        if (connection != null) {
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUserCode(), user.getUserName(), user.getUserPassword(),
                    user.getUserRole(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getCreationDate(), user.getCreatedBy()};
            addRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return addRows;
    }

    /**
     * @param connection
     * @param delId
     * @description: ͨ��idɾ���û�
     */
    @Override
    public int deleteUserById(Connection connection, Integer delId) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if (connection != null) {
            String sql = "delete from smbms_user where id=?";
            Object[] params = {delId};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    /**
     * @param connection
     * @param id
     * @description: ͨ��id��ȡuser
     */
    @Override
    public User getUserById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id=? and u.userRole = r.id";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return user;
    }

    /**
     * @param connection
     * @param user
     * @description: �޸��û���Ϣ
     */
    @Override
    public int userModify(Connection connection, User user) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "update smbms_user set userName=?," +
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";

            Object[] params = {user.getUserName(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getUserRole(), user.getModifyBy(),
                    user.getModifyDate(), user.getId()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }
}
