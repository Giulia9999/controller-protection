package com.example.controllerprotection.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
public class Salary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal amount;

    @OneToOne
    private UserBase userBase;

    public Salary() {
    }

    public Salary(Long id, BigDecimal amount, UserBase userBase) {
        this.id = id;
        this.amount = amount;
        this.userBase = userBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserBase getUser() {
        return userBase;
    }

    public void setUser(UserBase userBase) {
        this.userBase = userBase;
    }

}

