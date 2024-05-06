package com.example.backpiece.projection;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.SportEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "criteriaProjection", types = CriteriaEntity.class)
public interface CriteriaProjection {
    String getCriteriaName();
    SportEntity getSportEntity();
}
