package com.example.Banking.Repository;

import com.example.Banking.Dto.UserDto;
import com.example.Banking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public UserDto findByUsername(String username);
}
