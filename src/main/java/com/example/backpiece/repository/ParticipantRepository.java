package com.example.backpiece.repository;

import com.example.backpiece.entity.ParticipantEntity;
import com.example.backpiece.entity.SportEntity;
import com.example.backpiece.projection.ParticipantProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
    List<ParticipantProjection> findAllBy();
}
