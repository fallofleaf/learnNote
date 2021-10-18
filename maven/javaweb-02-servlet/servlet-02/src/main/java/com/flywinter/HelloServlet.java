package com.flywinter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/13 22:49
 * Description:
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter(); 初始化参数
//        this.getServletConfig(); Servlet配置
//        this.getServletContext(); Servlet上下文
        ServletContext servletContext = this.getServletContext();
        String name = "flywinter";//数据
        servletContext.setAttribute("userName",name);//将一个数据保存在ServletContext中

        System.out.println("Hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
