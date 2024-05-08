package com.example.backpiece.service;

import com.example.backpiece.dto.ScoreDTO;
import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
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
}
