package com.example.person.mapper;

import com.example.person.model.v1.CourseDTO;
import com.example.person.persistence.entity.CourseEntity;
import com.example.person.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {
    @Autowired
    private PersonRepository personRepository;

    public CourseEntity mapToEntity(CourseDTO dto) {
        CourseEntity entity = new CourseEntity();
        entity.setId(dto.getId());
        entity.setNomecorso(dto.getNomecorso());
        //entity.setPersone(personMapper.mapToEntityList(dto.getPersone()));
        return entity;
    }

    public CourseDTO mapToDTO(CourseEntity entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setNomecorso(entity.getNomecorso());
        //dto.setPersone(personMapper.mapToDTOList(entity.getPersone()));
        return dto;
    }

    public List<CourseEntity> mapToEntityList(List<CourseDTO> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public List<CourseDTO> mapToDTOList(List<CourseEntity> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .toList();
    }
}
