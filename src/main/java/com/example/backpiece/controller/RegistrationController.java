package com.example.backpiece.controller;

import com.example.backpiece.entity.MyUser;
import com.example.backpiece.exceptions.NotFoundException;
import com.example.backpiece.exceptions.UnknownMailException;
import com.example.backpiece.exceptions.UserAlreadyExistsException;
import com.example.backpiece.repository.MyUserRepository;
import com.example.backpiece.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    MyUserService userService;
    @PostMapping("register/user")
    public MyUser createUser(@RequestBody MyUser user) throws UserAlreadyExistsException {
        if(!myUserRepository.findByUsername(user.getUsername()).isPresent() && !myUserRepository.findByMail(user.getMail()).isPresent()) {
            if(!user.getMail().isEmpty()) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userService.sendActivationEmail(user);
                return myUserRepository.save(user);
            } else {
                throw new UnknownMailException("Введите корректный email");
            }
        } else {
            throw new UserAlreadyExistsException("Пользователь с таким именем или email уже существует");
        }

    }
    @PostMapping("/giveAdminRules")
    public MyUser giveAdminRules(@RequestBody MyUser user) throws NotFoundException {
        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(user.getUsername());
        if (myUserOptional.isPresent()) {
            MyUser myUser = myUserOptional.get();
            myUser.setRole("ADMIN,USER");
            return myUserRepository.save(myUser);
        } else {
            throw new NotFoundException("User not found");
        }
    }
    @PostMapping("/takeAdminRules")
    public MyUser takeAdminRules(@RequestBody MyUser user) throws NotFoundException{
        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(user.getUsername());
        if (myUserOptional.isPresent()) {
            MyUser myUser = myUserOptional.get();
            myUser.setRole("USER");
            return myUserRepository.save(myUser);
        } else {
            throw new NotFoundException("User not found");
        }
    }
}
