package com.flywinter.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 18:04
 * Description:
 */
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听
    //一旦创建session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        System.out.println(httpSessionEvent.getSession().getId());
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);
    }
    //销毁session监听
    //一旦销毁session就会触发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count-1);
        }
        servletContext.setAttribute("OnlineCount",onlineCount);
    }
    /*
    Session销毁
    手动销毁
    自动销毁
    */
}
