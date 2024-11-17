package com.lms.exam.service;

import com.lms.exam.dto.ExamDTO;
import com.lms.exam.model.Exam;

import java.util.List;

public interface ExamService {
    Exam createExam(ExamDTO examDTO);
    Exam updateExam(Long examId, ExamDTO examDTO);
    Exam getExamById(Long examId);
    List<Exam> getExamsByCourseId(Long courseId);
    void deleteExam(Long examId);
}

