package com.flywinter.servlet;

import com.flywinter.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 18:33
 * Description:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        String username = req.getParameter("username");
        if (username.equals("admin")) {
            req.getSession().setAttribute(Constant.USER_SESSION,req.getSession().getId());
            resp.sendRedirect("/sys/success.jsp");
        }else {
            //登陆失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
