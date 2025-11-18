package com.example.Banking.UserServices;

import com.example.Banking.Entity.UserEntity;
import com.example.Banking.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
    }
}
