package com.flywinter;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/21 17:17
 * Description:
 */
public class MainDemo1 {
    //����һ����ʼ�
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");//����QQ������
        properties.setProperty("mail.transport.protocol","smtp");//�ʼ�����Э��
        properties.setProperty("mail.smtp.auth","true");//��Ҫ��֤�û���������
        //����QQ���䣬����Ҫ����SSL����
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",sf);
        //ʹ��JavaMail�����ʼ���5������
        //1.������������Ӧ�ó������軷����Ϣ��Session����
        //QQ����
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //�������ʼ��û��� ��Ȩ��
                return new PasswordAuthentication("1475795322@qq.com", "erxfsldwxryybagg");
            }
        });
        //����session��debugģʽ�������Ϳ��Կ���Email�ķ���״̬
        session.setDebug(true);
        //2.ͨ��session�õ�transport����
        Transport transport = session.getTransport();
        //3.ʹ��������û�������Ȩ�������ʼ�������
        transport.connect("smtp.qq.com","1475795322@qq.com","erxfsldwxryybagg");
        //4.�����ʼ�
        //ע����Ҫ����session
        MimeMessage me = new MimeMessage(session);
        //ָ���ʼ��ķ�����
        me.setFrom(new InternetAddress("1475795322@qq.com"));
        //ָ���ʼ���s�ռ��ˣ��Լ����Լ���Ҳ����
        me.setRecipient(Message.RecipientType.TO,new InternetAddress("1475795322@qq.com"));
        //�ʼ��ı���
        me.setSubject("hello");
//        me.setContent("����","text/html;charset=UTF-8");
        //׼��ͼƬ����
        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource("E:\\learnNote\\project\\FunctionExtern\\mail-java\\src\\im.jpg"));
        image.setDataHandler(handler);
        image.setContentID("im.jpg");//��ͼƬ����һ��ID�������ʹ�ã����Ժ�ͼƬ���ֲ�һ��
        //׼����������
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("����һ���ͼƬ���ʼ�<img src='cid:im.jpg'>","text/html;charset=UTF-8");
//        �������ݹ�ϵ
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        //���õ���Ϣ��
        me.setContent(mimeMultipart);
        me.saveChanges();
        //5.�����ʼ�
        transport.sendMessage(me,me.getAllRecipients());
        //6.�ر�����
        transport.close();
    }
}
