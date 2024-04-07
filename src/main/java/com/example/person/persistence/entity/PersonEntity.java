package com.example.person.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
@Table(name = "persone")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String cognome;

    private Integer eta;

    @Valid
    @OneToMany(mappedBy = "owner")
    private List<BookEntity> libri = null;

    @Valid
    @ManyToMany
    @JoinTable(name = "person_course",
            joinColumns = @JoinColumn(name = "personid"),
            inverseJoinColumns = @JoinColumn(name = "courseid"))
    private List<CourseEntity> corsi = null;
}
