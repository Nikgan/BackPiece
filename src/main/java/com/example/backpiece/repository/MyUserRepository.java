package com.example.backpiece.repository;

import com.example.backpiece.entity.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MyUserRepository extends CrudRepository<MyUser,Long> {
    Optional<MyUser> findByUsername(String username);
}
