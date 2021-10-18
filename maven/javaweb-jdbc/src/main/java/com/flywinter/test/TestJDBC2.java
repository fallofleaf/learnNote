package com.flywinter.test;

import java.sql.*;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 20:03
 * Description:
 */
public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.编写SQL
        String sql = "insert into users (id, name, password, email, birthday) VALUES (?,?,?,?,?)";
        //5.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,4); //给第一个占位符的赋值为1
        preparedStatement.setString(2,"name"); //给第二个占位符的赋值为name
        preparedStatement.setString(3,"pass"); //给第三个占位符的赋值为pass
        preparedStatement.setString(4,"z@foxmail.com"); //给第四个占位符的赋值为z@foxmail.com
        preparedStatement.setDate(5,new Date(System.currentTimeMillis())); //给第五个占位符的赋值为Date()
        //6.执行sql语句 返回结果集
        int i = preparedStatement.executeUpdate();
        if (i>0) {
            System.out.println("插入成功");
        }
        //7.关闭连接，释放资源，先开后关
        preparedStatement.close();
        connection.close();
    }
}
