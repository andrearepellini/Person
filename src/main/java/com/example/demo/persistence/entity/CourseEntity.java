package com.example.demo.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
@Table(name = "corsi")
@NoArgsConstructor
@Data
public class CourseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nomecorso;

    @Valid
    @ManyToMany(mappedBy = "corsi")
    private List<PersonEntity> persone = null;
}
