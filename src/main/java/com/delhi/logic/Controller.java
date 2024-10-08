package com.delhi.logic;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.delhi.persistence.controller.*;
import com.delhi.persistence.entity.Investment;

public class Controller {
    private EntityManagerFactory emf;

    private ProductCtr prod;
    private StockCtr stock;
    private SellCtr sell;
    private InvestmentCtr investment;

    public Controller() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
        prod = new ProductCtr(emf);
        stock = new StockCtr(emf);
        sell = new SellCtr(emf);
        investment = new InvestmentCtr(emf);
    }
}
