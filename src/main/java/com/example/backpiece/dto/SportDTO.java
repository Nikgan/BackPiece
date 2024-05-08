package com.example.backpiece.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportDTO {
    private String sportName;

    public SportDTO(String sportName) {
        this.sportName = sportName;
    }
}