package com.example.backpiece.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportWithoutIdDTO {
    private Long id;
    private String sportName;

    public SportWithoutIdDTO(Long id, String sportName) {
        this.id = id;
        this.sportName = sportName;

    }
}