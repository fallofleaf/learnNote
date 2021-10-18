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
    //发送一封简单邮件
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");//设置QQ服务器
        properties.setProperty("mail.transport.protocol","smtp");//邮件发送协议
        properties.setProperty("mail.smtp.auth","true");//需要验证用户名和密码
        //关于QQ邮箱，还需要设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",sf);
        //使用JavaMail发送邮件的5个步骤
        //1.创建定义整个应用程序所需环境信息的Session对象
        //QQ才有
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名 授权码
                return new PasswordAuthentication("1475795322@qq.com", "erxfsldwxryybagg");
            }
        });
        //开启session的debug模式，这样就可以看到Email的发送状态
        session.setDebug(true);
        //2.通过session得到transport对象
        Transport transport = session.getTransport();
        //3.使用邮箱的用户名和授权码连上邮件服务器
        transport.connect("smtp.qq.com","1475795322@qq.com","erxfsldwxryybagg");
        //4.创建邮件
        //注意需要传递session
        MimeMessage me = new MimeMessage(session);
        //指明邮件的发件人
        me.setFrom(new InternetAddress("1475795322@qq.com"));
        //指明邮件的s收件人，自己给自己发也可以
        me.setRecipient(Message.RecipientType.TO,new InternetAddress("1475795322@qq.com"));
        //邮件的标题
        me.setSubject("hello");
//        me.setContent("内容","text/html;charset=UTF-8");
        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource("E:\\learnNote\\project\\FunctionExtern\\mail-java\\src\\im.jpg"));
        image.setDataHandler(handler);
        image.setContentID("im.jpg");//给图片设置一个ID后面可以使用，可以和图片名字不一样
        //准备正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封带图片的邮件<img src='cid:im.jpg'>","text/html;charset=UTF-8");
//        描述数据关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");
        //设置到消息中
        me.setContent(mimeMultipart);
        me.saveChanges();
        //5.发送邮件
        transport.sendMessage(me,me.getAllRecipients());
        //6.关闭连接
        transport.close();
    }
}
