package com.flywinter.test;

import java.sql.*;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 20:03
 * Description:
 */
public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.向数据库发送SQL的对象statement PreparedStatement CRUD
        Statement statement = connection.createStatement();
        //5.编写SQL
        String sql = "select * from users";

//        String delete = "delete from users where id = 1";
//        受影响的行数,增删改都是这个
//        int update = statement.executeUpdate(delete);


        //6.执行sql语句 返回结果集
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }
        //7.关闭连接，释放资源，先开后关
        resultSet.close();
        statement.close();
        connection.close();



    }
}
