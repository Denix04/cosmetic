package com.delhi.persistence.controller;
import com.delhi.persistence.entity.*;

import jakarta.persistence.EntityManagerFactory;

public class InvestmentCtr extends Controller<Investment> {

    public InvestmentCtr() {
        super("cosmetic", Investment.class);
    }

    public InvestmentCtr(EntityManagerFactory emf) {
        super(emf, Investment.class);
    }

}
