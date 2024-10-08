package com.delhi.persistence.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

import com.delhi.persistence.entity.*;

public class ProductCtr {
    private EntityManagerFactory emf;

    public ProductCtr() {
        emf = Persistence.createEntityManagerFactory("cosmetic");
    }

    public ProductCtr(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Product prod) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(prod);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error in create new product in database" 
                    + e.getMessage());
        }
    }

    public List<Product> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Product> prods = null;
        try {
            prods = em.createQuery( "SELECT * FROM Productos WHERE name = \"" + name + "\"")
                .getResultList();
        } catch (Exception e) {
            System.err.println("Error in find" + name + " products"
                    + e.getMessage());
        }
        
        return prods;
    }
    public List<Product> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Product> prods = null;
        try {
            prods = em.createQuery("SELECT * FROM Productos").getResultList();
        } catch (Exception e) {
            System.err.println("Error in find all the products"
                    + e.getMessage());
        }
        
        return prods;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Product prod = em.find(Product.class, id);
            if(prod != null) {
//TODO make the change in the product to update
                em.merge(prod);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error in remove product in database" 
                    + e.getMessage());
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Product prod = em.find(Product.class, id);
            if(prod != null)
                em.remove(prod);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error in remove product in database" 
                    + e.getMessage());
        }
    }
}
