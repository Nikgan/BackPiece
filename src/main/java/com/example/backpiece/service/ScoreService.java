package com.example.backpiece.service;

import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.entity.SportEntity;
import com.example.backpiece.exceptions.SportAlreadyExistsException;
import com.example.backpiece.projection.ScoreProjection;
import com.example.backpiece.projection.SportProjection;
import com.example.backpiece.repository.ScoreRepository;
import com.example.backpiece.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    public ScoreEntity addScore(ScoreEntity score) {
        return scoreRepository.save(score);
    }
    public List<ScoreProjection> getAllScore(){
        List<ScoreProjection> score = scoreRepository.findAllBy();
        return score;
    }
}
