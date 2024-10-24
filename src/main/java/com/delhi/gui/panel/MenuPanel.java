package com.delhi.gui.panel;

import java.awt.event.*;

import javax.swing.*;

import com.delhi.gui.Frame;

public class MenuPanel extends JPanel {

    private JButton stockBtn;
    private JButton fncBtn;
    private JButton sellsBtn;
    private JButton prodBtn;
    private JButton quitBtn;

    public MenuPanel() {

        setLayout(null);

        prodBtn = new JButton("Productos");
        stockBtn = new JButton("Stock");
        sellsBtn = new JButton("Ventas");
        fncBtn = new JButton("Financias");
        quitBtn = new JButton("Salir");

        addBtns();
        initBtns();
        addActions();
    }

    private void addBtns() {
        add(prodBtn);
        add(stockBtn);
        add(sellsBtn);
        add(fncBtn);
        add(quitBtn);
    }

    private void initBtns(){
        prodBtn.setBounds   (300,100,150,50);
        stockBtn.setBounds  (300,200,150,50);
        sellsBtn.setBounds  (300,300,150,50);
        fncBtn.setBounds    (300,400,150,50);
        quitBtn.setBounds   (300,500,150,50);
    }

    private void addActions() {

        prodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(1000, 700);
                ProductPanel pp = new ProductPanel(frm);
                frm.add(pp);
            }
        });

        stockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(1000, 700);
                StockPanel pp = new StockPanel(frm);
                frm.add(pp);
            }
        });

        sellsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(1000, 700);
                SellPanel pp = new SellPanel(frm);
                frm.add(pp);
            }
        });

        fncBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(1000, 700);
                FinancePanel fp = new FinancePanel(frm);
                frm.add(fp);
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
}
