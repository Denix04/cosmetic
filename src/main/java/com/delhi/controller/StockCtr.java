package com.delhi.controller;
import com.delhi.entity.*;

import java.util.List;
import jakarta.persistence.*;

public class StockCtr extends Controller<Stock> {

    public StockCtr() {
        super(Stock.class);
    }

    public List<Stock> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Stock> prods = null;
        try {
            prods = em.createQuery(
                "FROM Stock WHERE name = \"" + name + "\"",Stock.class)
                .getResultList();
        } catch (Exception e) {
            System.err.println("DB Error: Finging " + name + " in stock"
                    + e.getMessage());
        } finally { em.close(); }

        return prods;
    }
}
