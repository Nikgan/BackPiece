package com.example.backpiece.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @GetMapping
    public ResponseEntity getScore(){
        try{
            return ResponseEntity.ok("good");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("bad");
        }
    }
}
