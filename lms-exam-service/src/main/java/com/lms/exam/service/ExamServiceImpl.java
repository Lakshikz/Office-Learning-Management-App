package com.lms.exam.service;

import com.lms.exam.dto.ExamDTO;
import com.lms.exam.exception.ExamNotFoundException;
import com.lms.exam.model.Exam;
import com.lms.exam.repository.ExamRepository;
import com.lms.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private static final String TOPIC = "exam_topic";

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Exam createExam(ExamDTO examDTO) {
        Exam exam = Exam.builder()
                .title(examDTO.getTitle())
                .courseId(examDTO.getCourseId())
                .date(examDTO.getDate())
                .totalMarks(examDTO.getTotalMarks())
                .build();

        Exam savedExam = examRepository.save(exam);
        kafkaTemplate.send(TOPIC, "New exam created: " + savedExam.getTitle());
        return savedExam;
    }

    @Override
    public Exam updateExam(Long examId, ExamDTO examDTO) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + examId));

        exam.setTitle(examDTO.getTitle());
        exam.setDate(examDTO.getDate());
        exam.setTotalMarks(examDTO.getTotalMarks());

        Exam updatedExam = examRepository.save(exam);
        kafkaTemplate.send(TOPIC, "Exam updated: " + updatedExam.getTitle());
        return updatedExam;
    }

    @Override
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + examId));
    }

    @Override
    public List<Exam> getExamsByCourseId(Long courseId) {
        return examRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteExam(Long examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + examId));
        examRepository.delete(exam);
        kafkaTemplate.send(TOPIC, "Exam deleted with id: " + examId);
    }
}

