package com.example.backpiece.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParticipantScoreDTO {
    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private double score;
}