package com.flywinter.service.user;

import com.flywinter.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 21:15
 * Description:
 */
public interface UserService {
    //�û���¼
    public User login(String userCode,String password);
    //�����û�id�޸�����
    boolean updatePwd(int id,String password);
    //��ѯ��¼��
    int getUserCount(String username,int userRole);

    List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);

    boolean add(User user);

    User selectUserCodeExist(String userCode);

    boolean deleteUserById(Integer delId) throws Exception;

    User getUserById(String id);

    boolean userModify(User user);
}
