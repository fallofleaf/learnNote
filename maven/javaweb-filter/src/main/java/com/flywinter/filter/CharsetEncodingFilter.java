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
    //��ʼ�� web�����������ͳ�ʼ���� ��ʱ�ȴ����˶���
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharsetEncodingFilter��ʼ��");
    }

//    chain ��
//    �������е����д��룬�ڹ����ض������ʱ�򶼻�ִ��
//    ����Ҫ�ù���������ִ��
//    filterChain.doFilter(servletRequest, servletResponse);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharsetEncodingFilterִ��ǰ");
        filterChain.doFilter(servletRequest, servletResponse);//�����ǵ���������ߣ������д������������ͱ�����ֹͣ��
        System.out.println("CharsetEncodingFilterִ�к�");
    }

    //���� web�������رյ�ʱ�򣬹�����������
    @Override
    public void destroy() {
        System.gc();
        System.out.println("CharsetEncodingFilter Destroyed");
    }
}
