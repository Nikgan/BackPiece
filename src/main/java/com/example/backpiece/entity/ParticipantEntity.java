package com.example.backpiece.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name="participant")
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    private String middle_name;
    @JoinColumn(name = "sport", referencedColumnName = "id")
    @OneToOne
    private Long sport_id;

}
