package com.example.backpiece.repository;

import com.example.backpiece.entity.ScoreEntity;
import com.example.backpiece.projection.ScoreProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {
    List<ScoreProjection> findAllBy();
}
