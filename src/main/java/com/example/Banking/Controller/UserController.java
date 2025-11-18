package com.example.Banking.Controller;

import com.example.Banking.Entity.UserEntity;
import com.example.Banking.Service.Impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserImpl userImpl;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userImpl.addUser(userEntity);
    }

    @GetMapping("/showUser")
    public List<UserEntity> showAll(){
        return userImpl.showAll();
    }
}
