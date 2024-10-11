package com.delhi.logic;

import com.delhi.persistence.controller.ProductCtr;
import com.delhi.persistence.entity.Product;

public class ProductSvc {

    private ProductCtr prodCtr;

    public ProductSvc() {
        prodCtr = new ProductCtr();
    }
}
