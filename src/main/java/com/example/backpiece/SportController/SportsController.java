package com.example.backpiece.SportController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sport")
public class SportsController {
    public ResponseEntity getNamesOfSports(){
    return ResponseEntity.ok("gg");
    }
}
