package com.delhi.persistence.controller;

import jakarta.persistence.*;

import java.util.List;

public class Controller<T> {
    protected static EntityManagerFactory emf;
    static { emf = Persistence.createEntityManagerFactory("cosmetic");}

    protected Class<T> cls;

    public Controller(Class<T> cls) {
        this.cls = cls;
    }

    public void create(T elemt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(elemt);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Appending new element in database" 
                    + e.getMessage());
        } finally { em.close();}
    }

    public T find(Long id) {
        EntityManager em = emf.createEntityManager();
        T elemt = null;
        try {
            elemt = em.find(cls, id);
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finging element" + e.getMessage());
        } finally { em.close();}
        
        return elemt;
    }
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        List<T> elemts = null;
        try {
            elemts = em.createQuery("FROM " + cls.getName(),cls)
                .getResultList();
        } catch (Exception e) {
            System.err.println(
                "DB Error: Finding all the elements " + e.getMessage());
        } finally { em.close();}
        
        return elemts;
    }

    public void update(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            T elemt = em.find(cls, id);
            if(elemt != null) {
//TODO make the change in the elemtuct to update
                em.merge(elemt);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(
                "DB Error: Updating element" + e.getMessage());
        } finally { em.close();}
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            T elemt = em.find(cls, id);
            if(elemt != null)
                em.remove(elemt);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("DB Error: Deleting element" 
                    + e.getMessage());
        } finally { em.close();}
    }
}
