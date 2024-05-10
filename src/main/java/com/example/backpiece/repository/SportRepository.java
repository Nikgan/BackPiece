package com.example.backpiece.repository;

import com.example.backpiece.entity.SportEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SportRepository extends CrudRepository<SportEntity,Long> {
    SportEntity findBySportName(String sportName);
}