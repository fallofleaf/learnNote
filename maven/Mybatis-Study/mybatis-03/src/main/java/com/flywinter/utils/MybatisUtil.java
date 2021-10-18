package com.flywinter.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/21 23:55
 * Description:
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //1.��ȡsqlSessionFactory����
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
//    ��Ȼ���� SqlSessionFactory������˼�壬���ǿ��Դ��л�� SqlSession ��ʵ����
//    SqlSession �ṩ�������ݿ�ִ�� SQL ������������з�����
//    �����ͨ�� SqlSession ʵ����ֱ��ִ����ӳ��� SQL ��䡣���磺
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
