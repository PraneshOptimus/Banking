package com.example.Banking.Service.Impl;


import com.example.Banking.Entity.UserEntity;
import com.example.Banking.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl {

    @Autowired
    UserRepo userRepo;

    public List<UserEntity> showAll() {
        return userRepo.findAll();
    }


    public UserEntity addUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }
}
