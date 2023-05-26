package com.example.controllerprotection.controllers;

import com.example.controllerprotection.entities.UserBase;
import com.example.controllerprotection.repositories.UserRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<UserBase> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBase> getUserById(@PathVariable Long id) {
        UserBase userBase = userRepo.getReferenceById(id);
        return ResponseEntity.ok(userBase);
    }

    @PostMapping
    public ResponseEntity<UserBase> createUser(@RequestBody UserBase userBase) {
        UserBase createdUserBase = userRepo.save(userBase);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserBase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserBase> updateUser(@PathVariable Long id, @RequestBody UserBase userBase) {
        UserBase updatedUserBase = userRepo.getReferenceById(id);
        updatedUserBase.setUsername(userBase.getUsername());
        updatedUserBase.setPassword(userBase.getPassword());
        updatedUserBase.setSalary(userBase.getSalary());

        return ResponseEntity.ok(updatedUserBase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
