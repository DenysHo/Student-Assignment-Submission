package org.infrafrontier.student.assignment.submission.service.validator;

import jakarta.validation.Validator;
import org.infrafrontier.student.assignment.submission.dto.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentValidatorService extends BaseValidator<Assignment> {

    @Autowired
    public AssignmentValidatorService(Validator validator) {
        super(validator);
    }
}
