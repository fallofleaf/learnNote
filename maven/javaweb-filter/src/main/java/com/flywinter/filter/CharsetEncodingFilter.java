package com.flywinter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 17:17
 * Description:
 */
public class CharsetEncodingFilter implements Filter {
    //初始化 web服务器启动就初始化了 随时等待过滤对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharsetEncodingFilter初始化");
    }

//    chain 链
//    过滤器中的所有代码，在过滤特定请求的时候都会执行
//    必须要让过滤器继续执行
//    filterChain.doFilter(servletRequest, servletResponse);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharsetEncodingFilter执行前");
        filterChain.doFilter(servletRequest, servletResponse);//让我们的请求继续走，如果不写，程序在这里就被拦截停止了
        System.out.println("CharsetEncodingFilter执行后");
    }

    //销毁 web服务器关闭的时候，过滤器会销毁
    @Override
    public void destroy() {
        System.gc();
        System.out.println("CharsetEncodingFilter Destroyed");
    }
}
