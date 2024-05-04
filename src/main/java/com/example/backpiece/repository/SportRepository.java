package com.example.backpiece.repository;

import com.example.backpiece.entity.SportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SportRepository extends CrudRepository<SportEntity,Long>{
}