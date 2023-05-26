package com.example.controllerprotection.repositories;

import com.example.controllerprotection.entities.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserBase, Long> {
}
