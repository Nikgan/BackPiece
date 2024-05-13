package com.example.backpiece.repository;

import com.example.backpiece.dto.ParticipantCriteriasDTO;
import com.example.backpiece.dto.ParticipantScoreDTO;
import com.example.backpiece.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
    @Query("SELECT NEW com.example.backpiece.dto.ParticipantScoreDTO(p.id, p.surname, p.name, p.middleName, SUM(s.score)) \n" +
            "FROM ParticipantEntity p \n" +
            "JOIN ScoreEntity s ON p.id = s.participantEntity.id\n" +
            "GROUP BY p.id, p.surname, p.name, p.middleName")
    List<ParticipantScoreDTO> getParticipantScores();
    @Query("SELECT c.criterionName " +
            "FROM CriteriaEntity c " +
            "JOIN SportEntity s ON c.sportEntity.id = s.id " +
            "JOIN ParticipantEntity p ON p.sportEntity.id = s.id " +
            "WHERE p.id = :participantId")
    List<String> getCriteriaNamesByParticipantId(@Param("participantId") Long participantId);
}
