package com.example.backpiece.service;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.exceptions.CriteriaAlreadyExistsException;
import com.example.backpiece.exceptions.ParticipantAlreadyExistsException;
import com.example.backpiece.projection.CriteriaProjection;
import com.example.backpiece.projection.ParticipantProjection;
import com.example.backpiece.repository.CriteriaRepository;
import com.example.backpiece.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaService {
    @Autowired
    CriteriaRepository criteriaRepository;
    public CriteriaEntity addCriteria(CriteriaEntity criteria) throws CriteriaAlreadyExistsException {
        return criteriaRepository.save(criteria);
    }
    public List<CriteriaProjection> getAllCriteria(){
        List<CriteriaProjection> criteria = criteriaRepository.findAllBy();
        return criteria;
    }
}