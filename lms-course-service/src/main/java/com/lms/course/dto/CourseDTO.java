package com.lms.course.dto;

import lombok.*;

/**
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String title;
    private String description;
    private String instructorId;

}
