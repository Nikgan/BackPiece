package com.example.backpiece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackPieceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackPieceApplication.class, args);
    }

}
