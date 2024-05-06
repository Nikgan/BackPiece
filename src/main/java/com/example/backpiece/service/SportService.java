package com.example.backpiece.service;

import com.example.backpiece.entity.SportEntity;
import com.example.backpiece.exceptions.SportAlreadyExistsException;
import com.example.backpiece.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {
    @Autowired
    SportRepository sportRepository;
    public SportEntity addSport(SportEntity sport) throws SportAlreadyExistsException {
        if(sportRepository.findBySportName(sport.getSportName()) != null ){
            throw new SportAlreadyExistsException("Такой спорт уже существует.");
        }
        return sportRepository.save(sport);
    }
}
