package com.example.backpiece.service;

import com.example.backpiece.dto.CriteriaDTO;
import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.exceptions.CriteriaAlreadyExistsException;
import com.example.backpiece.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriteriaService {
    @Autowired
    CriteriaRepository criteriaRepository;
    public CriteriaEntity addCriteria(CriteriaEntity criteria) throws CriteriaAlreadyExistsException {
        return criteriaRepository.save(criteria);
    }
    public Iterable<CriteriaEntity> getAllCriteria(){
        Iterable<CriteriaEntity> criteriaIterable = criteriaRepository.findAll();
        return criteriaIterable;
    }
}