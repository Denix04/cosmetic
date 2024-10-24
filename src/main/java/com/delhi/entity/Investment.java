package com.delhi.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder.In;

import java.time.LocalDate;

@Entity
@Table(name = "Inversiones")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private LocalDate date;
    private double amount;
    private String description;

    public Investment() {

    }

    public Investment(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
