package com.flywinter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/15 23:55
 * Description:
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. - 要获取下载文件的路径
//        String realPath = this.getServletContext().getRealPath("/1.jpeg");
        String realPath = "E:\\learnNote\\maven\\javaweb-02-servlet\\response\\target\\classes\\1.jpeg";
        System.out.println("下载文件的路径："+realPath);
//                - 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
//                - 设置让浏览器支持下载我们需要的东西  文件如果为中文名需要指定编码
        resp.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
//                - 获取下载文件的输入流
        FileInputStream inputStream = new FileInputStream(realPath);
//                - 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//                - 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
//                - 将FileOutStream流写入到buffer缓冲区  - 使用OutputStream输出到客户端
        while ((len = inputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        inputStream.close();
        outputStream.close();
    }
}
