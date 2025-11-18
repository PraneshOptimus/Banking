package com.example.Banking.Repository;

import com.example.Banking.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsername(String username);
}
