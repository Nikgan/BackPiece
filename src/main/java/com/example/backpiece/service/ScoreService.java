package com.example.backpiece.service;

import com.example.backpiece.dto.ParticipantDTO;
import com.example.backpiece.dto.ScoreDTO;
import com.example.backpiece.dto.ScoreUpdateRequestDTO;
import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.MyUser;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.exceptions.NotFoundException;
import com.example.backpiece.repository.CriteriaRepository;
import com.example.backpiece.repository.MyUserRepository;
import com.example.backpiece.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    CriteriaRepository criteriaRepository;
    @Autowired
    MyUserRepository userRepository;

    public ScoreEntity addScore(ScoreEntity score, Authentication authentication) {
        String username = authentication.getName();
        score.setUser(userRepository.findByUsername(username).get());
        return scoreRepository.save(score);
    }

    public List<ScoreDTO> getAllScores() {
        Iterable<ScoreEntity> scoreIterable = scoreRepository.findAll();
        List<ScoreDTO> scoreDTOs = new ArrayList<>();
        for (ScoreEntity score : scoreIterable) {
            scoreDTOs.add(new ScoreDTO(score));
        }
        return scoreDTOs;
    }

    public void updateScoreForParticipantAndCriteria(ScoreUpdateRequestDTO scoreUpdateRequest,
                                                     Authentication authentication) throws NotFoundException {
        String username = authentication.getName();
        MyUser user = (userRepository.findByUsername(username)).get();
        CriteriaEntity criteriaEntity = criteriaRepository.findByCriterionName(scoreUpdateRequest.getCriterionName());
        if (criteriaEntity != null) {
            ScoreEntity scoreEntity = scoreRepository.findByCriteriaEntityAndParticipantIdAndUsername(criteriaEntity,
                    scoreUpdateRequest.getParticipantId(),user.getUsername());
            if (scoreEntity != null) {
                scoreEntity.setScore(scoreUpdateRequest.getScore());
                scoreEntity.setUser(user);
                scoreRepository.save(scoreEntity);
            }
        }
        else {
            throw new NotFoundException("Not found");
        }
    }
}