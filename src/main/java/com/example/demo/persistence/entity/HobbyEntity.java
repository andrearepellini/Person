package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hobbies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HobbyEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long personid;

    private String nomehobby;
}
