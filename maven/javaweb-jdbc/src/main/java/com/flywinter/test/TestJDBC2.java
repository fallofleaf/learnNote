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
        //1.������Ϣ
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        //2.��������
        Class.forName("com.mysql.jdbc.Driver");
        //3.�������ݿ⣬�������ݿ�
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.��дSQL
        String sql = "insert into users (id, name, password, email, birthday) VALUES (?,?,?,?,?)";
        //5.Ԥ����
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,4); //����һ��ռλ���ĸ�ֵΪ1
        preparedStatement.setString(2,"name"); //���ڶ���ռλ���ĸ�ֵΪname
        preparedStatement.setString(3,"pass"); //��������ռλ���ĸ�ֵΪpass
        preparedStatement.setString(4,"z@foxmail.com"); //�����ĸ�ռλ���ĸ�ֵΪz@foxmail.com
        preparedStatement.setDate(5,new Date(System.currentTimeMillis())); //�������ռλ���ĸ�ֵΪDate()
        //6.ִ��sql��� ���ؽ����
        int i = preparedStatement.executeUpdate();
        if (i>0) {
            System.out.println("����ɹ�");
        }
        //7.�ر����ӣ��ͷ���Դ���ȿ����
        preparedStatement.close();
        connection.close();
    }
}
