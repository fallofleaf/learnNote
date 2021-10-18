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
        //1.配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        try {
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.连接数据库，代表数据库
            connection = DriverManager.getConnection(url, username, password);
            //4.通知数据库开启事务，fasle，开启
            connection.setAutoCommit(false);
            String sql = "update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql).executeUpdate();
//        人为制造异常
            int i = 1/0;
            String sql2 = "update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();
            connection.commit();//以上两条SQL都执行成功，就提交事务
        }catch (Exception e){
            //如果出现异常，就通知数据库回滚
            connection.rollback();
            System.out.println("出现了异常");
        }finally {
            connection.close();
        }
    }
}
