package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    List<CourseEntity> findByPersone_id(Long personid);
    List<CourseEntity> findByPersone_idAndPersone_id(Long personid, Long personid2);
}
