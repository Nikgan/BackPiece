package com.example.backpiece.controller;

import com.example.backpiece.entity.MyUser;
import com.example.backpiece.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivationController {

    @Autowired
    private MyUserRepository userRepository;

    @GetMapping("/activate")
    public String activateUser(@RequestParam("token") String token) {
        MyUser user = userRepository.findByActivationToken(token);
        if (user != null) {
            user.setEnabled(true);
            user.setActivationToken(null);
            userRepository.save(user);
        } else {
            return "Invalid token";
        }
        return "login";
    }
}