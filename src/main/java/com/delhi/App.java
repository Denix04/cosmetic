package com.delhi;

import jakarta.*;

import java.util.HashMap;
import java.util.List;

import com.delhi.gui.*;
import com.delhi.gui.panel.MenuPanel;
import com.delhi.controller.ProductCtr;
import com.delhi.entity.Product;

public class App {
    public static void main(String[] args ) {
        //EntityManagerFactory emf;
        //emf = Persistence.createEntityManagerFactory("cosmetic");


        MenuPanel mp = new MenuPanel();
        Frame frame = new Frame(800,600);

        frame.add(mp);
    }
}

/*
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


        ProductCtr prodCtr = new ProductCtr();
        prodCtr.create(prod);
        prodCtr.create(prod2);
        prodCtr.create(prod3);

        List<Product> prods = prodCtr.findAll();
        List<Product> prodsByName = prodCtr.findByName("labial");

        for(Product pro : prods)
            System.out.println(pro.toString());
            
        for(Product pro : prodsByName)
            System.out.println(pro.toString());
*/
