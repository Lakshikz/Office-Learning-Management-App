package com.lms.course.service;

import com.lms.course.dto.CourseDTO;
import com.lms.course.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(CourseDTO courseDTO);

    Course updateCourse(Long courseId, CourseDTO courseDTO);

    Course getCourseById(Long courseId);

    List<Course> getAllCourses();
}
