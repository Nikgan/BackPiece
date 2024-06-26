package com.example.backpiece.controller;

import com.example.backpiece.dto.ParticipantCriteriasDTO;
import com.example.backpiece.dto.ParticipantDTO;
import com.example.backpiece.dto.ParticipantScoreDTO;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.exceptions.ParticipantAlreadyExistsException;
import com.example.backpiece.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    @Autowired
    ParticipantService service;
    @PostMapping(path = "/save")
    public ResponseEntity saveParticipant(@RequestBody ParticipantEntity participant){
        try{
            service.addParticipant(participant);
            return ResponseEntity.ok("Participant has been saved");
        }catch (ParticipantAlreadyExistsException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
    @GetMapping(path = "getParticipantScore")
    public ResponseEntity<List<ParticipantScoreDTO>> getParticipantScore(){
        return ResponseEntity.ok(service.getParticipantScore());
    }
    @GetMapping
    public ResponseEntity<List<ParticipantDTO>> getParticipant() {
        return ResponseEntity.ok(service.getAllParticipant());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParticipantCriteriasDTO> getParticipantWithCriteriaNames(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCriteriaNamesByParticipantId(id));
    }
}

