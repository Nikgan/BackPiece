package com.example.backpiece.service;

import com.example.backpiece.entity.MyUser;
import com.example.backpiece.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findByUsername(username);
        if(user.isPresent()){
            var userObj = user.get();
            if (!userObj.isEnabled()) {
                throw new UsernameNotFoundException("User not activated");
            }
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }
    private String[] getRoles(MyUser user){
        if(user.getRole()==null){
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }
}
