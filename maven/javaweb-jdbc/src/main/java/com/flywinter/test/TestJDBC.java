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
        //1.������Ϣ
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        //2.��������
        Class.forName("com.mysql.jdbc.Driver");
        //3.�������ݿ⣬�������ݿ�
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.�����ݿⷢ��SQL�Ķ���statement PreparedStatement CRUD
        Statement statement = connection.createStatement();
        //5.��дSQL
        String sql = "select * from users";

//        String delete = "delete from users where id = 1";
//        ��Ӱ�������,��ɾ�Ķ������
//        int update = statement.executeUpdate(delete);


        //6.ִ��sql��� ���ؽ����
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }
        //7.�ر����ӣ��ͷ���Դ���ȿ����
        resultSet.close();
        statement.close();
        connection.close();



    }
}
