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
    @OneToOne
    @JoinColumn(name = "participant_id")
    private ParticipantEntity participantEntity;
    @OneToOne
    @JoinColumn(name = "criteria_id")
    private CriteriaEntity criteriaEntity;
    private double score;
}
