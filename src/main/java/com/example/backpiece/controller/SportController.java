package com.example.backpiece.controller;

import com.example.backpiece.dto.SportWithoutIdDTO;
import com.example.backpiece.entity.SportEntity;
import com.example.backpiece.exceptions.SportAlreadyExistsException;
import com.example.backpiece.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    SportService service;
    @PostMapping(path = "/save")
    public ResponseEntity saveSport(@RequestBody SportEntity sport){
        try{
            service.addSport(sport);
            return ResponseEntity.ok("Sport has been saved");
        }catch (SportAlreadyExistsException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<SportEntity>> getSports() {
        return ResponseEntity.ok(service.getAllSports());
    }
}
