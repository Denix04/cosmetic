package com.delhi.persistence.controller;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

import com.delhi.persistence.entity.*;

public class ClientCtr {
    private EntityManagerFactory emf;

    public ClientCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public ClientCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Client customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Appending new customer in database" 
                    + e.getMessage());
        }
    }

    public List<Client> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Client> customers = null;
        try {
            customers = em.createQuery(
                "FROM Client WHERE name = \"" + name + "\"", Client.class)
                .getResultList();
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finging " + name + " customer" + e.getMessage());
        }
        
        return customers;
    }
    public List<Client> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Client> customers = null;
        try {
            customers = em.createQuery( "FROM Client",Client.class)
                .getResultList();
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finding all the customers" + e.getMessage());
        }
        
        return customers;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Client customer = em.find(Client.class, id);
            if(customer != null) {
//TODO make the change in the customeruct to update
                em.merge(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(
                "DB Error: Updating customer" + e.getMessage());
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Client customer = em.find(Client.class, id);
            if(customer != null)
                em.remove(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Deleting customer" 
                    + e.getMessage());
        }
    }
    
}
