package com.example.controllerprotection.controllers;

import com.example.controllerprotection.entities.Salary;
import com.example.controllerprotection.repositories.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

    @Autowired
    private SalaryRepo salaryRepo;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryRepo.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Salary> getUserSalary(@PathVariable Long userId) {
        Salary salary = salaryRepo.getReferenceById(userId);
        return ResponseEntity.ok(salary);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Salary> createUserSalary(@RequestBody Salary salary) {
        Salary createdSalary = salaryRepo.save(salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalary);
    }
}
