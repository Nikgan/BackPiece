package com.example.backpiece.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportWithoutIdDTO {
    private String sportName;

    public SportWithoutIdDTO(String sportName) {
        this.sportName = sportName;
    }
}