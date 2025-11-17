package com.example.Banking.UserServices;

import com.example.Banking.Dto.UserDto;
import com.example.Banking.Entity.User;
import com.example.Banking.Exceptions.UserNotFoundException;
import com.example.Banking.Mapper.UserMapper;
import com.example.Banking.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto user = userRepo.findByUsername(username);

        return new UserDto(user.username(),user.password(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
    }
}
