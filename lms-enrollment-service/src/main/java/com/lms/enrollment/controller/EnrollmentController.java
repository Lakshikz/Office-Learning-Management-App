package com.lms.enrollment.controller;

import com.lms.enrollment.dto.EnrollmentDTO;
import com.lms.enrollment.model.Enrollment;
import com.lms.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Endpoint to enroll a student in a course
    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentService.enrollStudent(enrollmentDTO);
        return ResponseEntity.ok(enrollment);
    }

    // Endpoint to get all enrollments for a student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    // Endpoint to get all enrollments for a course
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByCourse(@PathVariable Long courseId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

    // Endpoint to delete an enrollment by ID
    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.noContent().build();
    }
}
