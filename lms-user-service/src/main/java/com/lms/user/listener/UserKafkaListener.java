package com.lms.user.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserKafkaListener {

    @KafkaListener(topics = "user-topic", groupId = "user_service_group")
    public void listenUserEvents(String message) {
        // Process the received message
        System.out.println("Received message: " + message);

        // Add your logic for handling user-related events
    }
}
