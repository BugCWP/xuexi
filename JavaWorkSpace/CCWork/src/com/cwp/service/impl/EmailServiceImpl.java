package com.cwp.service.impl;

import com.cwp.entity.Resident;
import com.cwp.service.EmailService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(Resident resident, String password) {
        //收件人邮箱
        String to=resident.getResidentAccount();
        //发件人邮箱
        String from="302771918@qq.com";
        //指定发送邮件的主机为smtp.qq.com
        String host="smtp.qq.com";
//        获取系统属性
        Properties properties=System.getProperties();
//        设置邮箱服务器
        properties.setProperty("mail.smtp.host",host);

        properties.put("mail.smtp.auth","true");
//        获取默认session对象
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("302771918@qq.com","snpslulvapugbiif");
            }
        });

        try {
//            创建默认的MimeMessage对象
            MimeMessage message=new MimeMessage(session);
//            Set Form：头部字段
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            message.setSubject("社区交流系统");
            message.setText("新密码："+password);
            Transport.send(message);
            System.out.println("已发送新密码给用户"+resident.getResidentAccount());
        }catch (MessagingException mex){
            mex.printStackTrace();
        }
        return false;
    }
}
