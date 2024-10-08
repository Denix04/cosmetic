package com.delhi.persistence.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StockCtr {
    private EntityManagerFactory emf;

    public StockCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public StockCtr(EntityManagerFactory emf) {
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
