package com.lms.exam.controller;

import com.lms.exam.dto.ExamDTO;
import com.lms.exam.model.Exam;
import com.lms.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    // Endpoint to create a new exam
    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody ExamDTO examDTO) {
        Exam createdExam = examService.createExam(examDTO);
        return ResponseEntity.ok(createdExam);
    }

    // Endpoint to update an existing exam
    @PutMapping("/{examId}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long examId, @RequestBody ExamDTO examDTO) {
        Exam updatedExam = examService.updateExam(examId, examDTO);
        return ResponseEntity.ok(updatedExam);
    }

    // Endpoint to get an exam by its ID
    @GetMapping("/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long examId) {
        Exam exam = examService.getExamById(examId);
        return ResponseEntity.ok(exam);
    }

    // Endpoint to get all exams by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Exam>> getExamsByCourseId(@PathVariable Long courseId) {
        List<Exam> exams = examService.getExamsByCourseId(courseId);
        return ResponseEntity.ok(exams);
    }

    // Endpoint to delete an exam by its ID
    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long examId) {
        examService.deleteExam(examId);
        return ResponseEntity.noContent().build();
    }
}

