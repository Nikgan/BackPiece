package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;

public class SaveScoreDTO {
    private Long id;
    private ParticipantEntity participantEntity;
    private CriteriaEntity criteriaEntity;
    private double score;
    public SaveScoreDTO(ScoreEntity scoreEntity){
        this.id = scoreEntity.getId();
        this.participantEntity = scoreEntity.getParticipantEntity();
        this.criteriaEntity = scoreEntity.getCriteriaEntity();
        this.score = scoreEntity.getScore();
    }
}

