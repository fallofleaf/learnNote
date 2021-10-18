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
    //Servlet 控制层调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet Start....");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库密码进行对比，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        if (user!=null) {
            //可以登录
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            //查无此人 无法登录
            //转发会登陆页面 顺便提示用户名或密码错误
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
