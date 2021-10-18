package com.flywinter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 23:06
 * Description:
 */
public class HelloServlet extends HttpServlet {

    //全栈: 后台+前端+数据库+运维
    //前端：后台Node.js+前端

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取前端参数
        String method = req.getParameter("method");
        if (method.equals("add")) {
            req.getSession().setAttribute("msg","执行了add方法");
        }
        if (method.equals("delete")) {
            req.getSession().setAttribute("msg","执行了delete方法");
        }
//        2.调用业务层
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
//        3.视图转发或重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
