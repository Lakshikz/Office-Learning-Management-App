package com.lms.exam.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "exam_topic", groupId = "group_id")
    public void handleExamMessages(String message) {
        System.out.println("Received message: " + message);
        // Implement the logic to handle the message, if needed.
    }
}

