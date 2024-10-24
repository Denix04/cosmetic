package com.delhi.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_Id")
    private Product product; 

    private LocalDate buyDate;
    private double buyPrice;

    public Stock() {
    }

    public Stock(Product prod, LocalDate buyDate, double buyPrice) {
        this.product = prod;
        this.buyDate = buyDate;
        this.buyPrice = buyPrice;
    }
    
}
