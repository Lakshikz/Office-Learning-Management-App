package com.lms.exam.dto;


import lombok.Data;

@Data
public class ExamDTO {
    private String title;
    private Long courseId;
    private String date;
    private Integer totalMarks;
}

