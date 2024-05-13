package com.example.backpiece.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreUpdateRequestDTO {
    private Long participantId;
    private String criterionName;
    private double score;
}
