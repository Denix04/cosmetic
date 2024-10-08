package com.delhi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Sell {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

    private double salePrice;
    private LocalDate buyDate;

    public Sell() {

    }

    public Sell(Product product, double salePrice, LocalDate buyDate) {
        this.product = product;
        this.salePrice = salePrice;
        this.buyDate = buyDate;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    
    public double getSalePrice() {
        return salePrice;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

}
