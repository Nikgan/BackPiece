package com.example.backpiece.repository;

import com.example.backpiece.dto.ParticipantScoreDTO;
import com.example.backpiece.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
    @Query("SELECT NEW com.example.backpiece.dto.ParticipantScoreDTO(p.surname, p.name, p.middleName, SUM(s.score)) \n" +
            "FROM ParticipantEntity p \n" +
            "JOIN ScoreEntity s ON p.id = s.participantEntity.id\n" +
            "GROUP BY p.surname, p.name, p.middleName")
    List<ParticipantScoreDTO> getParticipantScores();
}
