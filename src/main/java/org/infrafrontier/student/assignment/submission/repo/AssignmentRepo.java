package org.infrafrontier.student.assignment.submission.repo;

import org.infrafrontier.student.assignment.submission.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepo extends JpaRepository<AssignmentEntity, Long> {

    @Query("SELECT a FROM AssignmentEntity a JOIN FETCH a.submittedBy")
    List<AssignmentEntity> findAllWithStudents();
}
