package com.delhi.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

/**
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private long idProduct;
**/

    private double salePrice;
    private LocalDate buyDate;

    public Venta() {

    }

    public Venta(double salePrice, LocalDate buyDate) {
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
