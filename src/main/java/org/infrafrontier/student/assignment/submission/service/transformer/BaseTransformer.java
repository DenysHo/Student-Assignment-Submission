package org.infrafrontier.student.assignment.submission.service.transformer;

public interface BaseTransformer<ENTITY, DTO>{

    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);
}
