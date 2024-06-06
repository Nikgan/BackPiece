package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDTO {
    private Long id;
    private ParticipantEntity participantEntity;
    private CriteriaEntity criteriaEntity;
    private double score;
    public ScoreDTO(ScoreEntity scoreEntity){
        this.id = scoreEntity.getId();
        this.participantEntity = scoreEntity.getParticipantEntity();
        this.criteriaEntity = scoreEntity.getCriteriaEntity();
        this.score = scoreEntity.getScore();
    }
}
