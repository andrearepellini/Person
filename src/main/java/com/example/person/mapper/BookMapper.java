package com.example.person.mapper;

import com.example.person.model.v1.BookDTO;
import com.example.person.persistence.entity.BookEntity;
import com.example.person.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    @Autowired
    private PersonRepository personRepository;
    public BookEntity mapToEntity(BookDTO dto) {
        BookEntity entity = new BookEntity();
        entity.setId(dto.getId());
        entity.setTitololibro(dto.getTitololibro());
        entity.setOwner(personRepository.findById(dto.getPersonid()).orElseThrow());
        return entity;
    }

    public BookDTO mapToDTO(BookEntity entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitololibro(entity.getTitololibro());
        dto.setPersonid(entity.getOwner().getId());
        return dto;
    }

    public List<BookEntity> mapToEntityList(List<BookDTO> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    public List<BookDTO> mapToDTOList(List<BookEntity> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
