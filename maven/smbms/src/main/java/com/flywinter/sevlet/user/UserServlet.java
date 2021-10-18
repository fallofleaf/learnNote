package com.flywinter.sevlet.user;

import com.alibaba.fastjson.JSONArray;
import com.flywinter.entity.Role;
import com.flywinter.entity.User;
import com.flywinter.service.role.RoleServiceImpl;
import com.flywinter.service.user.UserService;
import com.flywinter.service.user.UserServiceImpl;
import com.flywinter.util.Constants;
import com.flywinter.util.PageSupport;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/20 12:19
 * Description: ʵ��Servlet����
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("savepwd".equals(method) && method != null) {
            this.updatePwd(req, resp);
        } else if ("pwdmodify".equals(method) && method != null) {
            this.pwdmodify(req, resp);
        } else if ("query".equals(method) && method != null) {
            this.userQuery(req, resp);
        } else if ("add".equals(method) && method != null) {
            this.add(req, resp);
        } else if ("getrolelist".equals(method) && method != null) {
            this.getRoleList(req, resp);
        } else if ("ucexist".equals(method) && method != null) {
            this.userCodeExist(req, resp);
        } else if ("view".equals(method) && method != null) {
            this.getUserById(req, resp, "userview.jsp");
        } else if ("modify".equals(method) && method != null) {
            this.getUserById(req, resp, "usermodify.jsp");
        } else if ("modifyexe".equals(method) && method != null) {
            this.userModify(req, resp);
        } else if ("deluser".equals(method) && method != null) {
            this.deleteUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * @description: �޸�����
     * @Param: [req, resp]
     * @Return: void
     */
    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flog = false;

        if (o != null && !StringUtils.isNullOrEmpty(newpassword)) {
            UserService userService = new UserServiceImpl();
            flog = userService.updatePwd(((User) o).getId(), newpassword);
            if (flog) {
                //�޸�����ɹ����Ƴ�Session
                req.setAttribute("message", "�޸�����ɹ����������������µ�¼");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "�޸�����ʧ��");
            }
        } else {
            req.setAttribute("message", "������������");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: ��֤������, Session�����û�������
     * @Param: [req, resp]
     * @Return: void
     */
    private void pwdmodify(HttpServletRequest req, HttpServletResponse resp) {
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //���ܵ�Map�������
        Map<String, String> resultMap = new HashMap<String, String>();

        //�����ж�
        if (o == null) {
            //1.SessionʧЧ�˻���Session������
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldpassword)) {
            //����Ϊ��
            resultMap.put("result", "error");
        } else {
            //��ȡSession�е��û�����
            String userPassword = ((User) o).getUserPassword();
            //�ж�����ľ������Ƿ��뵱ǰSession�е�����һ��
            if (oldpassword.equals(userPassword)) {
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray:����Ͱ͵�JSON�����࣬ת����ʽ
            /* resultMap=["result", "true","result", "false"]
               Json��ʽ={key:value}
            * */
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @description: ���û����в�ѯ���ص���ѵ㡿
     * @Param: [req, resp]
     * @Return: void
     * 1.��ȡ�û�ǰ�˵����ݣ���ѯ��
     * 2.�ж������Ƿ���Ҫִ�У���������ֵ�ж�
     * 3.Ϊ��ʵ�ַ�ҳ����Ҫ�������ǰҳ�����ҳ�棬ҳ���С��
     * 4.�û��б�չʾ
     * 5.����ǰ��
     */
    private void userQuery(HttpServletRequest req, HttpServletResponse resp) {
        //��ѯ�û��б�
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        //��ȡ�û��б�
        UserServiceImpl userService = new UserServiceImpl();

        //��һ�����������һ���ǵ�һҳ��ҳ���С�̶���
        //���ð�pageSizeд�������ļ�����������޸�
        int pageSize = 5;
        int currentPageNo = 1;

        if (queryUserName == null) {
            queryUserName = "";
        }
        if (temp != null && !temp.equals("")) {
            //����ѯ��ֵ 0��1��2��3��
            queryUserRole = Integer.parseInt(temp);
        }
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        //��ȡ�û�����
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        List<User> userList = null;

        //��ҳ��֧��
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        //���ҳ�����ܹ��м�ҳ�����totalCount�պ���pageSize������������ô�ǲ��Ƕ�����һҳ��
        int totalPageCount = ((int) (totalCount / pageSize)) + 1;

        //������ҳ��βҳ
        if (currentPageNo < 1) {
            //���ҳ��С�ڵ�һҳ������ʾ��һҳ
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            //���ҳ��������һҳ������ʾ���һҳ
            currentPageNo = totalPageCount;
        }

        //��ȡ�û��б�չʾ
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList", userList);

        //��ȡ��ɫ�б�
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();

        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);

        //����ǰ��
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: ����û�
     * @Param: [req, resp]
     * @Return: void
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //��ȡ������û�����
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        //����һ��User���󣬲��Ҹ��ݱ���ȡ����������������ֵ
        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User) req.getSession().getAttribute(Constants.USER_SESSION)).getId());

        //����Service��ķ���
        UserService userService = new UserServiceImpl();
        if (userService.add(user)) {
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("useradd.jsp").forward(req, resp);
        }
    }

    /**
     * @description: �����û���ɫ�б�
     * @Param: [req, resp]
     * @Return: void
     */
    private void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Role> roleList = null;
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //��roleListת����json���󷵻�
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(roleList));
        writer.flush();
        writer.close();
    }

    /**
     * @description: �ж�����û���userCode�Ƿ���ã��Ƿ��Ѿ���ռ���ˣ�
     * @Param: [req, resp]
     * @Return: void
     */
    private void userCodeExist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //���������ж����ݿ����Ƿ���ڸ��û�usercode�����ȵû�ȡ���û������userCode
        String userCode = req.getParameter("userCode");
        //���ܵ�Map�������
        Map<String, String> map = new HashMap<String, String>();
        //�ж������Ƿ�Ϊ��
        if (StringUtils.isNullOrEmpty(userCode)) {
            map.put("userCode", "empty");
        } else {
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if (user != null) {
                map.put("userCode", "exist");
            } else {
                map.put("userCode", "notexist");
            }
        }
        //��Map����ת����json����
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(map));
        writer.flush();
        writer.close();
    }

    /**
     * @description: ͨ��Id��ȡ�û����鿴�����ĳһ���û�
     * @Param: [request, response, url]
     * @Return: void
     */
    private void getUserById(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
        //��ȡ�����id
        String uid = req.getParameter("uid");
        if (!StringUtils.isNullOrEmpty(uid)) {
            UserServiceImpl userService = new UserServiceImpl();
            User userById = userService.getUserById(uid);
            req.setAttribute("user", userById);
            req.getRequestDispatcher(url).forward(req, resp);
        }
    }

    /**
     * @description: ���û������޸�
     * @Param: [req, resp]
     * @Return: void
     */
    private void userModify(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //���ո�������
        String id = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        //����һ��User���󣬲��Ҹ��ݱ���ȡ����������������ֵ
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User) req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        UserService userService = new UserServiceImpl();
        boolean modify = userService.userModify(user);
        if (modify) {
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("usermodify.jsp").forward(req, resp);
        }
    }

    /**
     * @description: ɾ���û�
     * @Param: [req, resp]
     * @Return: void
     */
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //����id
        String id = req.getParameter("uid");
        Integer deleteId = 0;

        try {
            deleteId = Integer.parseInt(id);
        } catch (Exception e) {
            deleteId = 0;
        }

        //��ȡSession�еĵ�¼id��
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        //��ȡSession�е��û�id
        Integer sessionId = ((User) o).getId();
        System.out.println("���յ���Ŀ��id��"+deleteId);
        System.out.println("��ǰ��¼�û�id��"+sessionId);

        HashMap<String, String> map = new HashMap<String, String>();
        if (deleteId <= 0) {
            map.put("delResult", "notexist");
        } else if (sessionId.equals(deleteId)) {
            //�ж�Ҫɾ����id�Ƿ���ڵ�ǰ��¼�û���id��
            map.put("delResult", "cannotdel");
        } else {
            UserServiceImpl userService = new UserServiceImpl();
            boolean b = false;
            try {
                b = userService.deleteUserById(deleteId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (b) {
                map.put("delResult", "true");
            } else {
                map.put("delResult", "false");
            }
        }
        //��mapת����json�������
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(map));
        writer.flush();
        writer.close();
    }
}
