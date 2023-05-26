package com.example.controllerprotection.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class UserBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    @OneToOne(mappedBy = "userBase", cascade = CascadeType.ALL)
    private Salary salary;

    public UserBase() {
    }

    public UserBase(Long id, String username, String password, Salary salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

}
