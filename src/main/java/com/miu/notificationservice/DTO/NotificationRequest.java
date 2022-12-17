package com.miu.notificationservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    private String studentName;
    private String studentEmail;
    private String courseName;
    private String professorName;
    private String hostUserEmail;


}
