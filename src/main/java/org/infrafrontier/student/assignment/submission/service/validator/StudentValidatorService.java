package org.infrafrontier.student.assignment.submission.service.validator;

import jakarta.validation.Validator;
import org.infrafrontier.student.assignment.submission.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentValidatorService extends BaseValidator<Student> {

    @Autowired
    public StudentValidatorService(Validator validator) {
        super(validator);
    }
}
