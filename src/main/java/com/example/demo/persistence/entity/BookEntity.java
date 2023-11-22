package com.example.demo.persistence.entity;

import com.example.demo.persistence.entity.PersonEntity;
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
