package com.delhi.persistence.controller;
import com.delhi.persistence.entity.*;

import java.util.List;
import jakarta.persistence.*;

public class SellCtr extends Controller<Sell> {

    public SellCtr() {
        super("cosmetic", Sell.class);
    }

    public SellCtr(EntityManagerFactory emf) {
        super(emf, Sell.class);
    }

    public List<Sell> findByClient(String clientName) {
        EntityManager em = emf.createEntityManager();
        List<Sell> sells = null;
        try {
//TODO make for find sell of a client
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finging sells for " + clientName + " in stock"
                + e.getMessage());
        }
        
        return sells;
    }
}
