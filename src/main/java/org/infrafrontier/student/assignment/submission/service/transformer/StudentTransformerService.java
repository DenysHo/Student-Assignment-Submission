package org.infrafrontier.student.assignment.submission.service.transformer;

import org.infrafrontier.student.assignment.submission.dto.Student;
import org.infrafrontier.student.assignment.submission.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentTransformerService implements BaseTransformer<StudentEntity, Student> {

    @Override
    public StudentEntity toEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        return studentEntity;
    }

    @Override
    public Student toDto(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setEmail(studentEntity.getEmail());
        return student;
    }
}
