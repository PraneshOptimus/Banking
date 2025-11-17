package com.example.Banking.Service.Impl;

import com.example.Banking.Dto.UserDto;
import com.example.Banking.Entity.User;
import com.example.Banking.Mapper.UserMapper;
import com.example.Banking.Repository.UserRepo;
import com.example.Banking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        User savedUser = userRepo.save(user);
        return UserMapper.maptoUserDto(savedUser);
    }

}
