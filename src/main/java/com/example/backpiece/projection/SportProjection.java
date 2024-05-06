package com.example.backpiece.projection;

import com.example.backpiece.entity.SportEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "sportProjection", types = SportEntity.class)
public interface SportProjection {
    String getSportName();
}