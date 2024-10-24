package com.delhi.logic;

import com.delhi.controller.ProductCtr;
import com.delhi.controller.SellCtr;
import com.delhi.controller.StockCtr;
import com.delhi.entity.Product;
import com.delhi.entity.Sell;
import com.delhi.entity.Stock;

import java.util.List;

public class Finance {

    static private double historicalTotal;
    static private double dayTotal;
    static private double monthTotal;
    static private double yearTotal;

    public Finance() {
    }
    
    public Finance(double ht, double dt, double mt, double yt) {
        historicalTotal = ht;
        dayTotal = dt;
        monthTotal = mt;
        yearTotal = yt;
    }

    public void calcHistorical() {
        SellCtr sellCtr = new SellCtr();
        StockCtr stockCtr = new StockCtr();

        double historical = 0;

        for (Sell sell : sellCtr.findAll()) {
            historical += 0;
        }
        for (Stock prod : stockCtr.findAll()) {
        }
    }

    public void calcDaily() {
    }

    public void calcMonthly() {
    }
}
