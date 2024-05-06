package com.example.backpiece.service;

import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.exceptions.ParticipantAlreadyExistsException;
import com.example.backpiece.projection.ParticipantProjection;
import com.example.backpiece.projection.SportProjection;
import com.example.backpiece.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepository;
    public ParticipantEntity addParticipant(ParticipantEntity participant) throws ParticipantAlreadyExistsException {
        return participantRepository.save(participant);
    }
    public List<ParticipantProjection> getAllParticipant(){
        List<ParticipantProjection> participant = participantRepository.findAllBy();
        return participant;
    }
}
