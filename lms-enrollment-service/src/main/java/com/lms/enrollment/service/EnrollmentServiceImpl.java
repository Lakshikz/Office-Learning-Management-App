package com.lms.enrollment.service;

import com.lms.enrollment.dto.EnrollmentDTO;
import com.lms.enrollment.exception.EnrollmentNotFoundException;
import com.lms.enrollment.model.Enrollment;
import com.lms.enrollment.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment enrollStudent(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = Enrollment.builder()
                .studentId(enrollmentDTO.getStudentId())
                .courseId(enrollmentDTO.getCourseId())
                .enrollmentStatus(enrollmentDTO.getEnrollmentStatus())
                .enrollmentDate(enrollmentDTO.getEnrollmentDate())
                .build();
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long enrollmentId, EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with id: " + enrollmentId));

        enrollment.setEnrollmentStatus(enrollmentDTO.getEnrollmentStatus());
        enrollment.setEnrollmentDate(enrollmentDTO.getEnrollmentDate());
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with id: " + enrollmentId));
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with id: " + enrollmentId));
        enrollmentRepository.delete(enrollment);
    }
}

