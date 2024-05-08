package com.example.backpiece.service;

import com.example.backpiece.dto.ParticipantDTO;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.exceptions.ParticipantAlreadyExistsException;
import com.example.backpiece.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepository;
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
}
