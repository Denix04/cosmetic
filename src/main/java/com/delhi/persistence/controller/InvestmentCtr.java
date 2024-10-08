package com.delhi.persistence.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InvestmentCtr {

    private EntityManagerFactory emf;

    public InvestmentCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public InvestmentCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create() {
    }

    public void delete() {
    }

    public void update() {
    }

    public void remove() {
    }
    
}
