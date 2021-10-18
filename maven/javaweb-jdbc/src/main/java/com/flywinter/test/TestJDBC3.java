package com.flywinter.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/18 20:33
 * Description:
 */
public class TestJDBC3 {

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        //1.������Ϣ
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        try {
            //2.��������
            Class.forName("com.mysql.jdbc.Driver");
            //3.�������ݿ⣬�������ݿ�
            connection = DriverManager.getConnection(url, username, password);
            //4.֪ͨ���ݿ⿪������fasle������
            connection.setAutoCommit(false);
            String sql = "update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql).executeUpdate();
//        ��Ϊ�����쳣
            int i = 1/0;
            String sql2 = "update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();
            connection.commit();//��������SQL��ִ�гɹ������ύ����
        }catch (Exception e){
            //��������쳣����֪ͨ���ݿ�ع�
            connection.rollback();
            System.out.println("�������쳣");
        }finally {
            connection.close();
        }
    }
}
