package com.delhi.persistence.entity;

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
    private List<Product> purchases;

    public Client() {
    }

    public Client(String name, String surname, List<Product> prods) {
        this.name = name;
        this.surname = surname;
        this.purchases = prods;
    }
}
