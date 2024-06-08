package com.example.backpiece.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreUpdateRequestDTO {
    private Long id;
    private Long participantId;
    private String criterionName;
    private String username;
    private double score;
}
