package com.example.backpiece.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criteria")
public class CriteriaController {
    @GetMapping
    public ResponseEntity getCriteriaName(){
        try {
            return ResponseEntity.ok("Xorosho");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Slomalos");
        }
    }
}
