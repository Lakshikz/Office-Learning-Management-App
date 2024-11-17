package com.lms.enrollment.dto;



import lombok.Data;

@Data
public class EnrollmentDTO {
    private Long studentId;
    private Long courseId;
    private String enrollmentStatus;  // Example: "ENROLLED", "CANCELLED"
    private String enrollmentDate;    // ISO 8601 date format (e.g., "2024-11-16")
}

