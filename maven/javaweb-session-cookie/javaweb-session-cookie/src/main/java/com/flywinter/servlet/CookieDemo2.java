package com.flywinter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/17 18:28
 * Description: 保存用户上一次访问的时间
 */
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器 告诉客户端来的时间，把这个时间封装成一个信件，下次来的时候带上，服务端就知道客户端上次访问的时间了
        //解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //设置一个cookie，名字必须要和删除的名字一致
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //将cookie有效期设置为0
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
