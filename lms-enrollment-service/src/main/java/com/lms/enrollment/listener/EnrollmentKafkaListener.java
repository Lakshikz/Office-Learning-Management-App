package com.lms.enrollment.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentKafkaListener {

    @KafkaListener(topics = "enrollment_topic", groupId = "group_id")
    public void handleEnrollmentMessages(String message) {
        System.out.println("Received enrollment message: " + message);
        // Implement the logic to process the enrollment-related message here
    }
}

