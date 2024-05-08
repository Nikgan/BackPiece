package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.SportEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriteriaDTO {
    private SportEntity sportEntity;
    private String criteriaName;
    public CriteriaDTO(CriteriaEntity criteria){
        this.sportEntity = criteria.getSportEntity();
        this.criteriaName = criteria.getCriteriaName();
    }

}
