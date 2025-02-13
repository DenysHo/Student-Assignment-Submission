package org.infrafrontier.student.assignment.submission.repo;

import org.infrafrontier.student.assignment.submission.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);
}
