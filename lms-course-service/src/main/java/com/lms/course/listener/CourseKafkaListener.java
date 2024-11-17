package com.lms.course.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CourseKafkaListener {

    @KafkaListener(topics = "course_topic", groupId = "group_id")
    public void handleCourseMessages(String message) {
        System.out.println("Received course message: " + message);
        // Implement the logic to process the course-related message here
    }
}
