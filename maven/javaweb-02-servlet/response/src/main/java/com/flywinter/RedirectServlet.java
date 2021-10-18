package com.flywinter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/17 16:48
 * Description:
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        resp.setHeader("Location",this.getServletContext().getContextPath()+"/verify");
        resp.setStatus(302);
        */
        resp.sendRedirect(this.getServletContext().getContextPath()+"/verify");//重定向
    }
}
