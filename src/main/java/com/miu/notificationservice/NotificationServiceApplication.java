package com.miu.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class NotificationServiceApplication {
//    @Autowired
//    private EmailController senderService;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//        senderService.sendEmail();
//    }


}
