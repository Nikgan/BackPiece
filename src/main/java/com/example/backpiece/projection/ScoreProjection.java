package com.example.backpiece.projection;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "scoreProjection", types = ScoreEntity.class)
public interface ScoreProjection {
    ParticipantEntity getParticipantEntity();
    CriteriaEntity getCriteriaEntity();
    Double getScore();
}
