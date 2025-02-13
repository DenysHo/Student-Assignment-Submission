package org.infrafrontier.student.assignment.submission.exception;

import jakarta.persistence.EntityNotFoundException;

public class StudentEntityNotFoundException extends EntityNotFoundException {

    public StudentEntityNotFoundException(Long studentId) {
        super("Student with id " + studentId + " not found");
    }
}
