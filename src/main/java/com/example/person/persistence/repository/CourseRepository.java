package com.example.person.persistence.repository;

import com.example.person.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    List<CourseEntity> findByPersone_id(Long personid);
    List<CourseEntity> findByPersone_idAndPersone_id(Long personid, Long personid2);
}
