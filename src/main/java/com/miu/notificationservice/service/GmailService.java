package com.miu.notificationservice.service;
//package edu.miu.notification.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import edu.miu.notification.DTO.EmailDetails;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
@Slf4j
public class GmailService implements EmailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;


    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;



    public String sendSimpleMail(){
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("waa.test.pro@gmail.com");
            helper.setTo("yemaneabrha21@gmail.com");
            helper.setSubject("SUBJECT1");
            helper.setText("details.getMsgBody()", true);
            javaMailSender.send(mimeMessage);
            return "message";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage notificationEmail = new SimpleMailMessage();
        notificationEmail.setFrom("pmanagement.cs545@gmail.com");
        notificationEmail.setSubject(subject);
        notificationEmail.setText(message);
        notificationEmail.setTo(to);

        javaMailSender.send(notificationEmail);
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String message) {

        boolean html = true;
        MimeMessage zmessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(zmessage);

        try{
            helper.setSubject(subject);
            helper.setFrom("waa.test.pro@gmail.com");
            helper.setTo(to);
            helper.setText(message, html);
            javaMailSender.send(zmessage);
            log.info(to);
            log.info("Email sent successfully");
        }
        catch (MessagingException e){

            log.error("Error occurred while sending email !");
            throw  new RuntimeException(e);
        }

    }
}
