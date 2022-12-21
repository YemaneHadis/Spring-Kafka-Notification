package com.miu.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailController {
    @Autowired
    private JavaMailSenderImpl mailSender;

//    public void sendEmail(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("se.yemanebalemu@gmail.com");
//        message.setTo("yemaneabrha21@gmail.com");
//        message.setText("this is text");
//        message.setSubject("This is subject");
//
//            mailSender.send(message);
//
//
//        System.out.println("Mail Sent Successfuly");
//    }
}
