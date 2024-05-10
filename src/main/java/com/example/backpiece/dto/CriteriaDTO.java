package com.example.backpiece.dto;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.SportEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriteriaDTO {
    private SportEntity sportEntity;
    private String criterionName;
    public CriteriaDTO(CriteriaEntity criterion){
        this.sportEntity = criterion.getSportEntity();
        this.criterionName = criterion.getCriterionName();
    }

}
