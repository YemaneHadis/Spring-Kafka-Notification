package com.miu.notificationservice.service.kafka;

import lombok.Data;

@Data
public class RegistrationStream {
    private String studentName;
    private String studentEmail;
    private String courseName;
    private String professorName;


}
