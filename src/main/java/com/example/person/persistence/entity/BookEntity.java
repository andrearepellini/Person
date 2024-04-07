package com.example.person.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "libri")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String titololibro;

    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonEntity owner;
}
