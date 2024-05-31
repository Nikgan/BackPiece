package com.example.backpiece.controller;

import com.example.backpiece.entity.MyUser;
import com.example.backpiece.exceptions.UserAlreadyExistsException;
import com.example.backpiece.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user) throws UserAlreadyExistsException {
        if(myUserRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return myUserRepository.save(user);
        } else {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
        }

    }
}
