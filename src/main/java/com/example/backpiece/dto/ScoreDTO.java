package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDTO {
    private ParticipantEntity participantEntity;
    private CriteriaEntity criteriaEntity;
    private double score;
    private String username;
    public ScoreDTO(ScoreEntity scoreEntity){
        this.participantEntity = scoreEntity.getParticipantEntity();
        this.criteriaEntity = scoreEntity.getCriteriaEntity();
        this.score = scoreEntity.getScore();
        this.username = scoreEntity.getUser().getUsername();
    }
}
