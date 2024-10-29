package com.delhi.controller;
import com.delhi.entity.*;

import java.util.List;
import jakarta.persistence.*;

public class ClientCtr extends Controller<Client> {

    public ClientCtr() {
        super(Client.class);
    }

    public List<Sell> findPurchases(Long clientId) {
        List<Sell> purchases = null;

        try {
            purchases = find(clientId).getPurchases();
        } catch (Exception e) {
            purchases = null;
        }

        return purchases;
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
        } finally { em.close(); }

        return customers;
    }
}
