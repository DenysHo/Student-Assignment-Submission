package org.infrafrontier.student.assignment.submission.service.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.infrafrontier.student.assignment.submission.exception.ValidationException;

import java.util.Set;

public class BaseValidator<T>{

    private final Validator validator;

    public BaseValidator(Validator validator) {
        this.validator = validator;
    }

    public void validate(T t) {
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }

}
