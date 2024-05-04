package com.example.backpiece.repository;

import com.example.backpiece.entity.ParticipantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
}
