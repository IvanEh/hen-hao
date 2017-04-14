package com.epam.training.mail;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class JavaMailSenderFactoryBean implements FactoryBean<JavaMailSender> {
    @Override
    public JavaMailSender getObject() throws Exception {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("hen.hao.mailsender@gmail.com");
        mailSender.setPassword("pswdpswd");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaMailSender.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
