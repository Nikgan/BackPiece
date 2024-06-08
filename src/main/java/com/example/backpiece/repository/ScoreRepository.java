package com.example.backpiece.repository;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.entity.MyUser;
import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.ScoreEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {
    @Query("SELECT s FROM ScoreEntity s JOIN s.participantEntity p JOIN s.user u " +
            "WHERE p.id = :participantId AND s.criteriaEntity = :criteriaEntity AND u.username = :username")
    ScoreEntity findByCriteriaEntityAndParticipantIdAndUsername(@Param("criteriaEntity") CriteriaEntity criteriaEntity, @Param("participantId") Long participantId, @Param("username") String username);
        List<ScoreEntity> findByParticipantEntityAndCriteriaEntity(ParticipantEntity participantEntity, CriteriaEntity criteriaEntity);
        List<ScoreEntity> findByUserAndParticipantEntity(MyUser user, ParticipantEntity participantEntity);
}
