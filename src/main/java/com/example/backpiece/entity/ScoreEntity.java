package com.example.backpiece.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name="score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "participant", referencedColumnName = "id")
    @OneToOne
    private Long participant_id;
    @JoinColumn(name = "criteria", referencedColumnName = "id")
    @OneToOne
    private Long criterion_id;
    private double score;
}
