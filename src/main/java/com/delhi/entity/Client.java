package com.delhi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany
    private List<Sell> purchases;

    public Client() {
    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, List<Sell> prods) {
        this.name = name;
        this.surname = surname;
        this.purchases = prods;
    }

    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }

    public List<Sell> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return (getName() + " " + getSurname());
    }
}
