package com.delhi.persistence.entity;


import jakarta.persistence.*;
import java.util.Map;

@Entity
@Table(name = "Productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String provider;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "attr")
    @Column(name = "value")
    @CollectionTable(name = "Prod_Attr", joinColumns = @JoinColumn(name = "Product_id"))
    private Map<String, String> attr;

    public Product() {

    }
    
    public Product(Map<String, String> attr, 
            String name, String brand, String provider) {
        this.attr = attr;
        this.name = name;
        this.brand = brand;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        String ret;
        ret = 
            "Producto: " + name + "\n\t" +
            "Marca: " + brand + "\n\t" +
            "Provedor: " + provider;

        for(String elem : attr.keySet()) {
            ret = ret + "\n\t" + elem + ": " + attr.get(elem);
        }

        return ret;
    }

}
