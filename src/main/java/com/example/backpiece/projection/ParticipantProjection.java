package com.example.backpiece.projection;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.SportEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.rest.core.config.Projection;

@JsonPropertyOrder({ "surname", "name", "middleName", "sportEntity" })
@Projection(name = "participantProjection", types = ParticipantEntity.class)

public interface ParticipantProjection {
    String getSurname();
    String getName();
    String getMiddleName();
    SportEntity getSportEntity();
}
