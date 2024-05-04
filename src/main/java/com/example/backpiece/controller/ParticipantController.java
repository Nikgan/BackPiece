package com.example.backpiece.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    @GetMapping
    public ResponseEntity getParticipantName(){
        try {
            return ResponseEntity.ok("Всё гуд!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибочка вышла");
        }

    }
}
