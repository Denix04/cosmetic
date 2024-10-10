package com.delhi.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.delhi.gui.Frame;

public class MenuPanel extends JPanel {

    private JButton stockBtn;
    private JButton invBtn;
    private JButton sellsBtn;
    private JButton prodBtn;
    private JButton quitBtn;

    public MenuPanel() {

        setLayout(null);

        prodBtn = new JButton("Productos");
        stockBtn = new JButton("Stock");
        sellsBtn = new JButton("Ventas");
        invBtn = new JButton("Inversiones");
        quitBtn = new JButton("Salir");

        addBtns();
        initBtns();
        addActions();

    }

    private void addBtns() {
        add(prodBtn);
        add(stockBtn);
        add(sellsBtn);
        add(invBtn);
        add(quitBtn);
    }

    private void initBtns(){
        prodBtn.setBounds   (300,100,150,50);
        stockBtn.setBounds  (300,200,150,50);
        sellsBtn.setBounds  (300,300,150,50);
        invBtn.setBounds    (300,400,150,50);
        quitBtn.setBounds   (300,500,150,50);
    }

    private void addActions() {

        prodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(600, 600);
                ProductPanel pp = new ProductPanel(frm);
                frm.add(pp);
            }
        });

        stockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(600, 600);
                StockPanel pp = new StockPanel(frm);
                frm.add(pp);
            }
        });

        sellsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(600, 600);
                SellPanel pp = new SellPanel(frm);
                frm.add(pp);
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
