package com.example.backpiece.dto;

import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.SportEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantDTO {
    private String surname;
    private String name;
    private String middleName;
    private SportEntity sportEntity;
    public ParticipantDTO(ParticipantEntity participantEntity){
        this.surname = participantEntity.getSurname();
        this.name = participantEntity.getName();
        this.middleName = participantEntity.getMiddleName();
        this.sportEntity = participantEntity.getSportEntity();
    }
}
