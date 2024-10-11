package com.delhi.persistence.controller;

import jakarta.persistence.*;

import java.util.List;

import com.delhi.persistence.entity.*;

public class ProductCtr extends Controller<Product>{

    public ProductCtr() {
        super(Product.class);
    }

    public List<Product> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Product> prods = null;
        try {
            prods = em.createQuery(
                "FROM Product WHERE name = \"" + name + "\"", Product.class)
                .getResultList();
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finging " + name + " products" + e.getMessage());
        } finally { em.close(); }
        
        return prods;
    }

}
