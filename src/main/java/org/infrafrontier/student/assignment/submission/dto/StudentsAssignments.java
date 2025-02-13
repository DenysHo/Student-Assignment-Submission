package org.infrafrontier.student.assignment.submission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsAssignments {

    private Student student;
    private List<Assignment> assignments;
}
