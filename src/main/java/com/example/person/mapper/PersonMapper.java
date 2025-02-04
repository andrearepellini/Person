package com.example.person.mapper;

import com.example.person.model.v1.PersonDTO;
import com.example.person.persistence.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CourseMapper courseMapper;
    public PersonEntity mapToEntity(PersonDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCognome(dto.getCognome());
        entity.setEta(dto.getEta());
        entity.setLibri(bookMapper.mapToEntityList(dto.getLibri()));
        return entity;
    }

    public PersonDTO mapToDTO(PersonEntity entity) {
        PersonDTO dto = new PersonDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCognome(entity.getCognome());
        dto.setEta(entity.getEta());
        dto.setLibri(bookMapper.mapToDTOList(entity.getLibri()));
        return dto;
    }

    public List<PersonEntity> mapToEntityList(List<PersonDTO> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public List<PersonDTO> mapToDTOList(List<PersonEntity> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .toList();
    }

    public Page<PersonDTO> mapToDTOPage(Page<PersonEntity> entityPage) {
        List<PersonDTO> dtoList = entityPage.getContent().stream()
                .map(this::mapToDTO)
                .toList();

        return new PageImpl<>(dtoList, entityPage.getPageable(), entityPage.getTotalElements());
    }

    public Page<PersonEntity> mapToEntityPage(Page<PersonDTO> dtoPage) {
        List<PersonEntity> entityList = dtoPage.getContent().stream()
                .map(this::mapToEntity)
                .toList();

        return new PageImpl<>(entityList, dtoPage.getPageable(), dtoPage.getTotalElements());
    }
}
