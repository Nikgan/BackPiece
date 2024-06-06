package com.example.backpiece.service;

import com.example.backpiece.dto.ParticipantCriteriasDTO;
import com.example.backpiece.dto.ParticipantDTO;
import com.example.backpiece.dto.ParticipantScoreDTO;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.exceptions.ParticipantAlreadyExistsException;
import com.example.backpiece.repository.CriteriaRepository;
import com.example.backpiece.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    CriteriaRepository criteriaRepository;
    public ParticipantEntity addParticipant(ParticipantEntity participant) throws ParticipantAlreadyExistsException {
        return participantRepository.save(participant);
    }
    public List<ParticipantDTO> getAllParticipant(){
        Iterable<ParticipantEntity> participant = participantRepository.findAll();
        List<ParticipantDTO> participantDTOs = new ArrayList<>();
        for (ParticipantEntity participantEntity : participant) {
            participantDTOs.add(new ParticipantDTO(participantEntity));
        }
        return participantDTOs;
    }
    public List<ParticipantScoreDTO> getParticipantScore(){
        return participantRepository.getParticipantScores();
    }
    public ParticipantCriteriasDTO getCriteriaNamesByParticipantId(Long participantId) {
        ParticipantEntity participant = participantRepository.findById(participantId).orElse(null);
        List<String> criteriaNames = participantRepository.getCriteriaNamesByParticipantId(participantId);
        ParticipantCriteriasDTO dto = new ParticipantCriteriasDTO(participant.getId(), participant.getName(),
                participant.getSurname(), participant.getMiddleName(), criteriaNames);
        return dto;
    }
}
