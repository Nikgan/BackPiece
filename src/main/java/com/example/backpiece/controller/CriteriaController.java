package com.example.backpiece.controller;

import com.example.backpiece.dto.CriteriaDTO;
import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.exceptions.CriteriaAlreadyExistsException;
import com.example.backpiece.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/criteria")
public class CriteriaController {
    @Autowired
    CriteriaService service;
    @PostMapping(path = "/save")
    public ResponseEntity saveCriteria(@RequestBody CriteriaEntity criteria){
        try{
            service.addCriteria(criteria);
            return ResponseEntity.ok("Criteria has been saved");
        }catch (CriteriaAlreadyExistsException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Save error");
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<CriteriaEntity>> getParticipant() {
        return ResponseEntity.ok(service.getAllCriteria());
    }
}
