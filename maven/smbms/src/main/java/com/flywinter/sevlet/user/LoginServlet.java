package com.flywinter.sevlet.user;

import com.flywinter.entity.User;
import com.flywinter.service.user.UserServiceImpl;
import com.flywinter.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 21:26
 * Description:
 */
public class LoginServlet extends HttpServlet {
    //Servlet ���Ʋ����ҵ������
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet Start....");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //�����ݿ�������жԱȣ�����ҵ���
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        if (user!=null) {
            //���Ե�¼
            //���û�����Ϣ�ŵ�Session��
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //��ת����ҳ
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            //���޴��� �޷���¼
            //ת�����½ҳ�� ˳����ʾ�û������������
            req.setAttribute("error","�û��������벻��ȷ");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
