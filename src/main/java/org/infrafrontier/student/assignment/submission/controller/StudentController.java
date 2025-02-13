package org.infrafrontier.student.assignment.submission.controller;

import org.infrafrontier.student.assignment.submission.dto.Student;
import org.infrafrontier.student.assignment.submission.service.StudentService;
import org.infrafrontier.student.assignment.submission.service.validator.StudentValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentValidatorService studentValidatorService;

    @Autowired
    public StudentController(StudentService studentService, StudentValidatorService studentValidatorService) {
        this.studentService = studentService;
        this.studentValidatorService = studentValidatorService;
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        studentValidatorService.validate(student);
        return studentService.register(student);
    }
}
