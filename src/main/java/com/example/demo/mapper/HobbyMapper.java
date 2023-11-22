package com.example.demo.mapper;

import com.example.demo.model.v1.HobbyDTO;
import com.example.demo.persistence.entity.HobbyEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HobbyMapper {
    public HobbyEntity mapToEntity(HobbyDTO dto) {
        HobbyEntity entity = new HobbyEntity();
        entity.setId(dto.getId());
        entity.setNomehobby(dto.getNomehobby());
        entity.setPersonid(dto.getPersonid());
        return entity;
    }

    public HobbyDTO mapToDTO(HobbyEntity entity) {
        HobbyDTO dto = new HobbyDTO();
        dto.setId(entity.getId());
        dto.setNomehobby(entity.getNomehobby());
        dto.setPersonid(entity.getPersonid());
        return dto;
    }

    public List<HobbyEntity> mapToEntityList(List<HobbyDTO> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    public List<HobbyDTO> mapToDTOList(List<HobbyEntity> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
