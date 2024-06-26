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
    @Column(name = "middle_name")
    private String middleName;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private SportEntity sportEntity;
}

