package com.delhi.persistence.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

import com.delhi.persistence.entity.*;

public class SellCtr {

    private EntityManagerFactory emf;

    public SellCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public SellCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Sell sell) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(sell);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Appending sell" 
                    + e.getMessage());
        }
    }

    public List<Sell> findByClient(String clientName) {
        EntityManager em = emf.createEntityManager();
        List<Sell> sells = null;
        try {
//TODO make for find sell of a client
        } catch (Exception e) {
            System.err.println("DB Error: Finging sells for " + clientName + " in stock"
                    + e.getMessage());
        }
        
        return sells;
    }
    public List<Sell> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Sell> sells = null;
        try {
            sells = em.createQuery("SELECT * FROM Ventas").getResultList();
        } catch (Exception e) {
            System.err.println("DB Error: Finding all the Sell"
                    + e.getMessage());
        }
        
        return sells;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Sell sells = em.find(Sell.class, id);
            if(sells != null) {
//TODO make the change in the sells to update
                em.merge(sells);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Updating Sell" 
                    + e.getMessage());
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Sell sells = em.find(Sell.class, id);
            if(sells != null)
                em.remove(sells);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Deleting sell"
                    + e.getMessage());
        }
    }
}
