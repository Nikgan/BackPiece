package com.example.backpiece.service;

import com.example.backpiece.dto.ScoreDTO;
import com.example.backpiece.dto.ScoreUpdateRequestDTO;
import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.repository.CriteriaRepository;
import com.example.backpiece.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    CriteriaRepository criteriaRepository;
    public ScoreEntity addScore(ScoreEntity score) {
        return scoreRepository.save(score);
    }
    public List<ScoreDTO> getAllScore(){
        Iterable<ScoreEntity> scoreIterable = scoreRepository.findAll();
        List<ScoreDTO> scoreDTOs = new ArrayList<>();
        for (ScoreEntity score : scoreIterable) {
            scoreDTOs.add(new ScoreDTO(score));
        }
        return scoreDTOs;
    }
    public void updateScoreForParticipantAndCriteria(ScoreUpdateRequestDTO scoreUpdateRequest) {
        CriteriaEntity criteriaEntity = criteriaRepository.findByCriterionName(scoreUpdateRequest.getCriterionName());
        if (criteriaEntity != null) {
            ScoreEntity scoreEntity = scoreRepository.findByCriteriaEntityAndParticipantId(criteriaEntity, scoreUpdateRequest.getParticipantId());
            if (scoreEntity != null) {
                scoreEntity.setScore(scoreUpdateRequest.getScore());
                scoreRepository.save(scoreEntity);
            }
        }
    }
}
