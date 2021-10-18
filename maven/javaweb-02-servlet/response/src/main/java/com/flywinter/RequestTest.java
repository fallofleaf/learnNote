package com.flywinter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/17 17:04
 * Description:
 */
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入这个请求了");
        //处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+":"+password);
        //重定向的时候一定要注意 路径问题 否则就会报404
        resp.sendRedirect(this.getServletContext().getContextPath()+"/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
