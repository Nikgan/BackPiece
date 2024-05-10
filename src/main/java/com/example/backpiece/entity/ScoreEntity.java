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
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private ParticipantEntity participantEntity;
    @OneToOne
    @JoinColumn(name = "criterion_id")
    private CriteriaEntity criteriaEntity;
    private double score;
}
