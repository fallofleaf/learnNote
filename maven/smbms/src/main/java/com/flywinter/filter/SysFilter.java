package com.flywinter.filter;

import com.flywinter.entity.User;
import com.flywinter.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/20 0:03
 * Description:
 */
public class SysFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //����������Session�л�ȡ�û�
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        if (user == null) {//�Ѿ����Ƴ�����ע���ˣ�����δ��¼
            response.sendRedirect("/smbms/error.jsp");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
