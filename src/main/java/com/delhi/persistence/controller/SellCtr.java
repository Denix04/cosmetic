package com.delhi.persistence.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SellCtr {

    private EntityManagerFactory emf;

    public SellCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public SellCtr(EntityManagerFactory emf) {
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
