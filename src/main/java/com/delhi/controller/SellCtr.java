package com.delhi.controller;
import com.delhi.entity.*;

import java.util.List;
import jakarta.*;

public class SellCtr extends Controller<Sell> {

    public SellCtr() {
        super(Sell.class);
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
        } finally { em.close(); }
        
        return sells;
    }
}
