package com.example.backpiece.repository;

import com.example.backpiece.entity.CriteriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends CrudRepository<CriteriaEntity, Long> {
    CriteriaEntity findByCriterionName(String criterionName);
}
