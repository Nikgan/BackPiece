package com.example.backpiece.controller;

import com.example.backpiece.dto.ScoreDTO;
import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService service;
    @PostMapping(path = "/save")
    public ResponseEntity saveScore(@RequestBody ScoreEntity score){
        try{
            service.addScore(score);
            return ResponseEntity.ok("Score has been saved");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
    @GetMapping
    public ResponseEntity<List<ScoreDTO>> getScore() {
        return ResponseEntity.ok(service.getAllScore());
    }
}
