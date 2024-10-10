package com.delhi;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;

import com.delhi.gui.*;
import com.delhi.persistence.controller.ProductCtr;
import com.delhi.persistence.entity.Product;

public class App {
    public static void main(String[] args ) {

        AppPanel panel = new AppPanel();
        AppFrame frame = new AppFrame(panel);
        System.out.println("Hello World!" );

        HashMap<String,String> attr = new HashMap<>();

        attr.put("type", "perfume");
        attr.put("gender", "male");
        attr.put("brand", "bagues");

        HashMap<String,String> attr2 = new HashMap<>();

        attr2.put("type", "maquillage");
        attr2.put("brand", "millanel");

        HashMap<String,String> attr3 = new HashMap<>();

        attr3.put("type", "Perfume");
        attr3.put("brand", "Mavelin");
        attr3.put("Color", "Red");

        Product prod = new Product(attr, "One millon", "bagues", "bagues"); 
        Product prod2 = new Product(attr2, "nose", "millanel", "tu mama"); 
        Product prod3 = new Product(attr3, "labial", "Mavelin", "Mabel"); 

        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("cosmetic");

        ProductCtr prodCtr = new ProductCtr(emf);
        prodCtr.create(prod);
        prodCtr.create(prod2);
        prodCtr.create(prod3);

        List<Product> prods = prodCtr.findAll();
        List<Product> prodsByName = prodCtr.findByName("labial");

        for(Product pro : prods)
            System.out.println(pro.toString());
            
        for(Product pro : prodsByName)
            System.out.println(pro.toString());
    }
}
