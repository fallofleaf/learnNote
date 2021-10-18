package com.flywinter.servlet;

import com.flywinter.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/17 22:09
 * Description:
 */
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //得到Session
        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("name",10));
        //给Session中存东西
        String id = session.getId();
        //判断Session是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，Id为:"+id);
        }else {
            resp.getWriter().write("Session已经在服务器中存在了:"+id);
        }
        //Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSSIONID", "sessionId");
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
