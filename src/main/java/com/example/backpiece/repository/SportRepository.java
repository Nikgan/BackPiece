package com.example.backpiece.repository;

import com.example.backpiece.entity.SportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SportRepository extends CrudRepository<SportEntity,Long> {
    SportEntity findBySportName(String sportName);
}