package com.quickhome.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Tim-h
 * @description 邮箱验证码工具
 * @creatDate 2023/6/28 14:33
 */
public class MailUtils {
    public static void sendMail(String email) throws Exception{
        // 1、创建一个程序与邮件服务器会话对象 Session
        // 创建参数配置，用于连接邮件服务器的参数配置
        Properties prop = new Properties();  // 参数配置
        prop.setProperty("mail.transport.protocol","SMTP"); // 使用协议，JavaMail规范要求
        prop.setProperty("mail.host","smtp.qq.com"); // 发件人邮箱的SMTP服务器地址
        prop.setProperty("mail.smtp.auth","true"); // 请求认证，参数名称与具体实现有关，指定验证为true

        // 创建验证器  输入授权码，不是密码
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 如我的邮箱  xxxxx@qq.com
                return new PasswordAuthentication("e-timj@foxmail.com","hegmymckvwqmbjgd");
            }
        };

        Session session = Session.getInstance(prop,auth);

        // 2、创建一个Message，它相当于邮件内容
        Message message = new MimeMessage(session);
        // 这里要和上面对应，否则报错
        message.setFrom(new InternetAddress("e-timj@foxmail.com"));

        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email)); // 设置发送方式和接收者

        // 设置邮件主题
        message.setSubject("邮件主题");

        // 设置邮件正文  emailMsg内容就是邮件的内容
        String emailMsg = "您的验证码为"+1000+"有效时间为10分钟";
        message.setContent(emailMsg,"text/html;charset=utf-8");

        // 3、创建Transport用于将邮件发送
        Transport.send(message);
    }
}
