package com.example.backpiece.repository;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.ScoreEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {
    @Query("SELECT s FROM ScoreEntity s JOIN s.participantEntity p " +
            "WHERE p.id = :participantId AND s.criteriaEntity = :criteriaEntity")
    ScoreEntity findByCriteriaEntityAndParticipantId(@Param("criteriaEntity") CriteriaEntity criteriaEntity, @Param("participantId") Long participantId);
}
