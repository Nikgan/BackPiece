package com.example.backpiece.service;

import com.example.backpiece.entity.MyUser;
import com.example.backpiece.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void save(MyUser user) {
        userRepository.save(user);
    }

    public void sendActivationEmail(MyUser user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getMail());
        message.setSubject("Account Activation");
        message.setText("To activate your account, click the link below:\n" +
                "http://localhost:8080/activate?token=" + generateActivationToken(user));
        message.setFrom("nik.ganenko@mail.ru");
        mailSender.send(message);
    }

    private String generateActivationToken(MyUser user) {
        String token = UUID.randomUUID().toString();
        user.setActivationToken(token);
        userRepository.save(user);
        return token;
    }
}
