package com.delhi.persistence.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

import com.delhi.persistence.entity.*;

public class StockCtr {
    private EntityManagerFactory emf;

    public StockCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public StockCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Stock stock) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(stock);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Appending product in stock" 
                    + e.getMessage());
        }
    }

    public List<Stock> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Stock> prods = null;
        try {
            prods = em.createQuery( "SELECT * FROM Stock WHERE name = \"" + name + "\"")
                .getResultList();
        } catch (Exception e) {
            System.err.println("DB Error: Finging " + name + " in stock"
                    + e.getMessage());
        }
        
        return prods;
    }
    public List<Stock> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Stock> prods = null;
        try {
            prods = em.createQuery("SELECT * FROM Stock").getResultList();
        } catch (Exception e) {
            System.err.println("DB Error: Finding all the products in Stock"
                    + e.getMessage());
        }
        
        return prods;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Stock prod = em.find(Stock.class, id);
            if(prod != null) {
//TODO make the change in the product to update
                em.merge(prod);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Updating product in Stock" 
                    + e.getMessage());
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Stock prod = em.find(Stock.class, id);
            if(prod != null)
                em.remove(prod);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Deleting product in stock"
                    + e.getMessage());
        }
    }
}
