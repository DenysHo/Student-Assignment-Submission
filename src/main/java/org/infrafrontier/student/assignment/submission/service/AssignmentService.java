package org.infrafrontier.student.assignment.submission.service;

import org.infrafrontier.student.assignment.submission.dto.Assignment;
import org.infrafrontier.student.assignment.submission.dto.StudentsAssignments;
import org.infrafrontier.student.assignment.submission.entity.AssignmentEntity;
import org.infrafrontier.student.assignment.submission.entity.StudentEntity;
import org.infrafrontier.student.assignment.submission.repo.AssignmentRepo;
import org.infrafrontier.student.assignment.submission.service.transformer.AssignmentTransformerService;
import org.infrafrontier.student.assignment.submission.service.transformer.StudentTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    private final AssignmentRepo assignmentRepo;
    private final StudentService studentService;
    private final AssignmentTransformerService assignmentTransformerService;
    private final StudentTransformerService studentTransformerService;

    @Autowired
    public AssignmentService(AssignmentRepo assignmentRepo, StudentService studentService, AssignmentTransformerService assignmentTransformerService, StudentTransformerService studentTransformerService) {
        this.assignmentRepo = assignmentRepo;
        this.studentService = studentService;
        this.assignmentTransformerService = assignmentTransformerService;
        this.studentTransformerService = studentTransformerService;
    }

    public List<StudentsAssignments> getAllStudentsWithAssignments() {
        List<AssignmentEntity> assignments = assignmentRepo.findAllWithStudents();

        Map<StudentEntity, List<AssignmentEntity>> studentAssignmentsMap = assignments.stream()
                .collect(Collectors.groupingBy(AssignmentEntity::getSubmittedBy));

        return studentAssignmentsMap.entrySet().stream()
                .map(entry -> new StudentsAssignments(
                        studentTransformerService.toDto(entry.getKey()),
                        entry.getValue().stream().map(assignmentTransformerService::toDto).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public Assignment createAssignment(Assignment assignment) {
        StudentEntity student = studentService.findById(assignment.getStudentId());
        AssignmentEntity entity = assignmentTransformerService.toEntity(assignment);
        entity.setSubmittedBy(student);
        AssignmentEntity savedAssignment = assignmentRepo.save(entity);
        return assignmentTransformerService.toDto(savedAssignment);
    }

}
