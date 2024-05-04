package com.example.backpiece.service;

import com.example.backpiece.entity.SportEntity;
import com.example.backpiece.exceptions.TestException;
import com.example.backpiece.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SportService {
    @Autowired
    SportRepository sportRepository;
    public SportEntity addSport(SportEntity sport) throws TestException {
        if(sportRepository.findById(sport.getId()) != null ){
            throw new TestException("test");
        }
        return sportRepository.save(sport);
    }
}
