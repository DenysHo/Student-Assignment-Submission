package org.infrafrontier.student.assignment.submission.service;

import org.infrafrontier.student.assignment.submission.dto.Student;
import org.infrafrontier.student.assignment.submission.entity.StudentEntity;
import org.infrafrontier.student.assignment.submission.exception.StudentEntityNotFoundException;
import org.infrafrontier.student.assignment.submission.repo.StudentRepo;
import org.infrafrontier.student.assignment.submission.service.transformer.StudentTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentTransformerService studentTransformerService;

    @Autowired
    public StudentService(StudentRepo studentRepo, StudentTransformerService studentTransformerService) {
        this.studentRepo = studentRepo;
        this.studentTransformerService = studentTransformerService;
    }

    public Student register(Student dto) {
        if (studentRepo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
        }
        StudentEntity entity = studentRepo.save(studentTransformerService.toEntity(dto));
        return studentTransformerService.toDto(entity);
    }

    public StudentEntity findById(Long id) {
        Optional<StudentEntity> student = studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new StudentEntityNotFoundException(id);
        }
        return student.get();
    }

}
