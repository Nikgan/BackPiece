package com.example.backpiece.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String mail;
    @Column
    private String username;
    @Column
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column
    private String role;
    private String activationToken;
    public MyUser() {
        super();
        this.enabled=false;
    }
}
