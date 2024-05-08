package com.example.backpiece.repository;

import com.example.backpiece.entity.ScoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {

}
