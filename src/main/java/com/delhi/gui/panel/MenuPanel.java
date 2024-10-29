package com.delhi.gui.panel;

import java.awt.event.*;

import javax.swing.*;

import com.delhi.gui.Frame;

public class MenuPanel extends JPanel {

    private JButton stockBtn;
    private JButton fncBtn;
    private JButton sellsBtn;
    private JButton prodBtn;
    private JButton clientBtn;
    private JButton quitBtn;

    public MenuPanel() {
        setLayout(null);

        initBtns();
        addBtns();
        addActions();
    }

    private void initBtns(){
        prodBtn = new JButton("Productos");
        stockBtn = new JButton("Stock");
        sellsBtn = new JButton("Ventas");
        fncBtn = new JButton("Financias");
        clientBtn = new JButton("Clientes");
        quitBtn = new JButton("Salir");

        prodBtn.setBounds   (300,025,150,50);
        stockBtn.setBounds  (300,125,150,50);
        sellsBtn.setBounds  (300,225,150,50);
        clientBtn.setBounds (300,325,150,50);
        fncBtn.setBounds    (300,425,150,50);
        quitBtn.setBounds   (300,525,150,50);
    }

    private void addBtns() {
        add(prodBtn);
        add(stockBtn);
        add(sellsBtn);
        add(fncBtn);
        add(clientBtn);
        add(quitBtn);
    }

    private void addActions() {

        prodBtn.addActionListener(e -> {
            Frame prodFrm = new Frame(1000, 700);
            ProductPanel prodPanel = new ProductPanel(prodFrm);
            prodFrm.add(prodPanel);
        });

        stockBtn.addActionListener(e -> {
            Frame stockFrm = new Frame(1000, 700);
            StockPanel stockPanel = new StockPanel(stockFrm);
            stockFrm.add(stockPanel);
        });

        sellsBtn.addActionListener(e -> {
            Frame sellFrm = new Frame(1000, 700);
            SellPanel sellPanel = new SellPanel(sellFrm);
            sellFrm.add(sellPanel);
        });

        clientBtn.addActionListener(e -> {
            Frame clientFrm = new Frame(1000,700);
            ClientPanel clientPanel = new ClientPanel(clientFrm);
            clientFrm.add(clientPanel);
        });

        fncBtn.addActionListener(e -> {
            Frame fncFrm = new Frame(1000, 700);
            FinancePanel fncPanel = new FinancePanel(fncFrm);
            fncFrm.add(fncPanel);
        });

        quitBtn.addActionListener(e ->  System.exit(0));
    }
    
}
