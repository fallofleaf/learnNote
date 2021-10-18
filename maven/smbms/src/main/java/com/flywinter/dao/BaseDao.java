package com.flywinter.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/19 20:09
 * Description:�������ݿ�Ĺ�����
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    //��̬����飬����ص�ʱ��ͳ�ʼ����
    static {
        Properties properties = new Properties();
       //ͨ�����������ȡ��Ӧ����Դ
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
    //��ȡ���ݿ������
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //��д��ѯ������
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        //Ԥ�����sql���ں���ֱ��ִ�оͿ���
         preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObjectռλ����1��ʼ���������ǵ������0��ʼ
            preparedStatement.setObject(i+1,params[i]);
        }
         resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //��д��ɾ�Ĺ�������
    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObjectռλ����1��ʼ���������ǵ������0��ʼ
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                //GC����
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                //GC����
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
                //GC����
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}
