package com.example.person.persistence.repository;

import com.example.person.persistence.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    Page<PersonEntity> findByNomeStartingWithIgnoreCase(String iniziale, Pageable pageable);
    List<PersonEntity> findByCorsi_id(Long courseid);
    List<PersonEntity> findByNomeAndCognome(String nome, String cognome);
}
