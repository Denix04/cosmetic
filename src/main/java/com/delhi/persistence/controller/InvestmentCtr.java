package com.delhi.persistence.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import com.delhi.persistence.entity.*;

public class InvestmentCtr {

    private EntityManagerFactory emf;

    public InvestmentCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public InvestmentCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Investment inv) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(inv);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Appending investment" 
                    + e.getMessage());
        }
    }

    public List<Investment> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Investment> invs = null;
        try {
            invs = em.createQuery("SELECT * FROM Inversiones").getResultList();
        } catch (Exception e) {
            System.err.println("DB Error: Finding all the investment"
                    + e.getMessage());
        }
        
        return invs;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Investment invs = em.find(Investment.class, id);
            if(invs != null) {
//TODO make the change in the sells to update
                em.merge(invs);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Updating investment" 
                    + e.getMessage());
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Investment invs = em.find(Investment.class, id);
            if(invs != null)
                em.remove(invs);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Deleting investment"
                    + e.getMessage());
        }
    }
}
