package com.example.backpiece.repository;

import com.example.backpiece.entity.CriteriaEntity;
import com.example.backpiece.projection.CriteriaProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaRepository extends CrudRepository<CriteriaEntity, Long> {
    List<CriteriaProjection> findAllBy();
}
