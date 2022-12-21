package com.miu.notificationservice.service.kafka;

import com.miu.notificationservice.DTO.NotificationRequest;
import com.miu.notificationservice.service.EmailTemplate;
import com.miu.notificationservice.service.GmailService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationTopicConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Value("$topic.courseRegistration.name")
    private String registrationEventTopic;


    @Autowired
    GmailService gmailService;

    @KafkaListener(topics = "${topic.courseRegistration.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, RegistrationStream> payload){
        logger.warn("Consumed Registration Event", payload);
        RegistrationStream registrationStream  = payload.value();
        NotificationRequest req =
                new NotificationRequest(
                        registrationStream.getStudentName(),
                        registrationStream.getStudentEmail(),
                        registrationStream.getCourseName(),
                        registrationStream.getProfessorName(),
                        "se.yemanebalemu@gmail.com"
                );
        System.out.println(req);
        gmailService.sendHtmlEmail(
                registrationStream.getStudentEmail(),
                "Registration Successful",
                new EmailTemplate().courseRegistration(req));

    }
}

