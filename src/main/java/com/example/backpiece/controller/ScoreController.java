package com.example.backpiece.controller;

import com.example.backpiece.dto.SaveScoreDTO;
import com.example.backpiece.dto.ScoreDTO;
import com.example.backpiece.dto.ScoreUpdateRequestDTO;
import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService service;
    @PostMapping(path = "/save")
    public ResponseEntity saveScore(@RequestBody ScoreEntity score, Authentication authentication){
        try{
            service.addScore(score,authentication);
            return ResponseEntity.ok("Score has been saved");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
    @GetMapping
    public ResponseEntity<List<ScoreDTO>> getScore() {
        return ResponseEntity.ok(service.getAllScores());
    }
    @PostMapping("/updateScore")
    public ResponseEntity<String> updateScoreForParticipantAndCriteria(@RequestBody ScoreUpdateRequestDTO scoreUpdateRequest, Authentication authentication) {
        try {
            service.updateScoreForParticipantAndCriteria(scoreUpdateRequest,authentication);
            return ResponseEntity.ok("Score updated successfully.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
}
