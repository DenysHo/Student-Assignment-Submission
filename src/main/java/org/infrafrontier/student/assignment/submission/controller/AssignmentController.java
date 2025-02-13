package org.infrafrontier.student.assignment.submission.controller;

import org.infrafrontier.student.assignment.submission.dto.Assignment;
import org.infrafrontier.student.assignment.submission.dto.StudentsAssignments;
import org.infrafrontier.student.assignment.submission.service.AssignmentService;
import org.infrafrontier.student.assignment.submission.service.validator.AssignmentValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final AssignmentValidatorService assignmentValidatorService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService, AssignmentValidatorService assignmentValidatorService) {
        this.assignmentService = assignmentService;
        this.assignmentValidatorService = assignmentValidatorService;
    }

    @PostMapping
    public Assignment submitAssignment(@RequestBody Assignment assignment) {
        assignmentValidatorService.validate(assignment);
        return assignmentService.createAssignment(assignment);
    }

    @GetMapping
    public List<StudentsAssignments> getAssignments() {
        return assignmentService.getAllStudentsWithAssignments();
    }
}
