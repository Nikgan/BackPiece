package com.example.backpiece.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "criteria")
public class CriteriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "sport", referencedColumnName = "id")
    @OneToOne
    private SportEntity sport_id;
    private String criterion_name;
}
