package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantCriteriasDTO {
    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private List criteriaNames;
    public ParticipantCriteriasDTO(Long id, String name, String surname, String middleName, List criteriaNames) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.criteriaNames = criteriaNames;
    }
}
