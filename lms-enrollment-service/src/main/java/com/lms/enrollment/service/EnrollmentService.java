package com.lms.enrollment.service;

import com.lms.enrollment.dto.EnrollmentDTO;
import com.lms.enrollment.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(EnrollmentDTO enrollmentDTO);
    Enrollment updateEnrollment(Long enrollmentId, EnrollmentDTO enrollmentDTO);
    Enrollment getEnrollmentById(Long enrollmentId);
    List<Enrollment> getEnrollmentsByStudentId(Long studentId);
    List<Enrollment> getEnrollmentsByCourseId(Long courseId);
    void deleteEnrollment(Long enrollmentId);
}
