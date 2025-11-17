package com.example.Banking.Mapper;

import com.example.Banking.Dto.UserDto;
import com.example.Banking.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public static UserDto maptoUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.username(),
                userDto.password()
        );
        return user;
    }

}
