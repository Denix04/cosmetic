package com.delhi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Sell {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_Id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_Id")
    private Client client;

    private double buyPrice;
    private double salePrice;
    private LocalDate buyDate;
    private LocalDate sellDate;
    

    public Sell() {

    }

    public Sell(Product product, double buyPrice, double salePrice,
            LocalDate buyDate, LocalDate sellDate) {
        this.product = product;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
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
