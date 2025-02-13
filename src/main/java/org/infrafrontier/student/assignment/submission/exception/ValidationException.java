package org.infrafrontier.student.assignment.submission.exception;

import jakarta.validation.ConstraintViolation;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidationException extends RuntimeException {

    public ValidationException(Set<? extends ConstraintViolation<?>> violations) {
        super(violations.stream()
                .map(v -> v.getPropertyPath() + " " + v.getMessage())
                .collect(Collectors.joining(", ")));
    }
}
