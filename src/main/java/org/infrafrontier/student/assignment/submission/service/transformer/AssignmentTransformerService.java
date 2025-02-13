package org.infrafrontier.student.assignment.submission.service.transformer;

import org.infrafrontier.student.assignment.submission.dto.Assignment;
import org.infrafrontier.student.assignment.submission.entity.AssignmentEntity;
import org.springframework.stereotype.Service;

@Service
public class AssignmentTransformerService implements BaseTransformer<AssignmentEntity, Assignment> {

    @Override
    public AssignmentEntity toEntity(Assignment dto) {
        AssignmentEntity entity = new AssignmentEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public Assignment toDto(AssignmentEntity entity) {
        Assignment dto = new Assignment();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStudentId(entity.getSubmittedBy().getId());
        return dto;
    }
}
